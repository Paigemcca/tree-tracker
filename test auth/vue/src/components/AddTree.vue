<template>
    <div class="container">
      <h1 class="title">Add a new tree to track</h1>
      <div class="create-tree">
        <form class="form-tree" v-on:submit.prevent="addTree">
          <fieldset>
            <div class="form-group">
              <label class="form-label" for="treeTag">Tag Number:</label>
              <input type="text" name="tree-tag" id="treeTag" class="form-input" v-model="newTree.treeTag" required placeholder="e.g. T123" />
            </div>
            <div class="form-group">
              <label class="form-label" for="treeDesc">Description:</label>
              <input type="text" name="tree-desc" id="treeDesc" class="form-input" v-model="newTree.treeDesc" placeholder="e.g. Oak tree in the front yard" />
            </div>
            <div class="form-group">
              <label class="form-label" for="treeHealth">How is this tree's health?</label>
              <input type="text" name="tree-health" id="treeHealth" class="form-input" v-model="newTree.treeHealth" placeholder="e.g. Healthy, needs maintenance" />
            </div>
            <div class="form-group">
              <label class="form-label" for="treePoem">Add a poem for your tree:</label>
              <textarea id="treePoem" name="tree-poem" rows="3" cols="30" class="form-input" v-model="newTree.treePoem" placeholder="I think that I shall never see
  A poem lovely as a tree."></textarea>
            </div>
            <div class="form-group">
              <label class="form-label" for="uploadPhoto">Upload a tree photo:</label>
              <input id="uploadPhoto" type="file" name="file" @change="uploadImage" class="form-input" />
            </div>
          </fieldset>
          <button class="submit-btn" type="submit">Submit</button>
        </form>
      </div>
    </div>
  </template>

<script>
import TreeService from '@/services/TreeService';

export default{
    name: 'new-tree',
    data(){
        return {
            newTree:{
                treeId: 0,
                treeTag: "",
                treeDesc: "",
                treeHealth: "",
                treePoem: "",
                treeImageURL: "",
            },
        }
    },
    methods: {
        addTree(){
            TreeService.createTree(this.newTree).then((response) =>{
                if(response.status === 200){
                    //
                }
            });
        },
        uploadImage(event){
            let uploadedFile = event.target.files[0];
            this.newTree.treeImageURL = URL.createObjectURL(uploadedFile);
        }
    },
}
</script>

<style>
.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
  
}
.title {
  font-size: 2rem;
  margin-bottom: 1rem;
  text-align: center;
  background-color: #f2f2f2;
  padding: 0.5rem 1rem;
}

create-tree {
    display: flex;
    height: 70vh;
    align-items: center;
    justify-content: center;
}

.form-tree {
    width: 60vw;
    max-width: 500px;
    min-width: 300px;
    padding: 2em;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0,0,0,.1);
}

.form-tree fieldset {
    border: none;
    padding: 2rem 0;
}

.form-tree label {
    display: block;
    margin: 0.5rem 0;
    color: #333;
    font-size: 1rem;
    font-weight: 600;
}

.form-tree input[type="text"],
.form-tree textarea {
    margin: 0;
    padding: .5rem;
    font-size: 1rem;
    border: 1px solid #ccc;
    border-radius: 4px;
    width: 100%;
    box-sizing: border-box;
}

#create-tree .form-tree input[type="submit"] {
    margin-top: 2rem;
    padding: .5rem 1rem;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 4px;
    font-size: 1rem;
    font-weight: 600;
    cursor: pointer;
}

#create-tree .form-tree input[type="submit"]:hover {
    background-color: #0069d9;
}

.form-tree textarea {
    resize: vertical;
    height: 8rem;
}

#create-tree .form-tree .photo {
    display: flex;
    align-items: center;
}

.photo input[type="file"] {
    display: none;
}

#create-tree .form-tree .photo label {
    margin-right: 1rem;
    padding: .5rem 1rem;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 4px;
    font-size: 1rem;
    font-weight: 600;
    cursor: pointer;
}

#create-tree .form-tree .photo label:hover {
    background-color: #0069d9;
}

</style>