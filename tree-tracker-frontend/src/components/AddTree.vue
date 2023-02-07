<template>
    <div class="container">
    <h1 class="title" id="add-title">Add a new tree to track</h1>
    </div>
    <div class ="create-tree">
        <form class="form-tree" v-on:submit="addTree">
        <fieldset>
            <label class="tag-num" for="tree-num">Tag Number: <input type="text" name="tree-tag" id="treeTag" 
                class="form-input" v-model="newTree.treeTag" required/></label>
            <label for="tree-desc" class="desc">Description: <input type="text" name="tree-desc" id="tree-desc" 
                class="form-input" v-model="newTree.treeDesc"/></label>
            <label for="tree-health" class="tree-health">How Is This Tree's Health? <input type="text" name="tree-health" id="tree-health" 
                class="form-input" v-model="newTree.treeHealth"/></label>
            <label for="tree-poem" class="poem">Add A Poem For Your Tree: 
                <textarea id="poem" name="tree-poem" rows="3" cols="30" v-model="newTree.treePoem" placeholder="I think that I shall never see
A poem lovely as a tree."></textarea></label> 
           <label for="tree-photo" class="photo" id="tree-photo"> Upload a Tree Photo: <input id="upload-photo" type="file" name="file" @change="uploadImage" /></label>            
            </fieldset>
            <input class="submit" id="submit" type="submit" value="Submit" />
        </form>
        


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
.container{
    display: flex;
    align-items: center;
    justify-content: center;
    height: 15vh;
}
#add-title{
    background-color: rgba(255, 255, 255, 0.5);
    backdrop-blur: 10px;
    width: auto;
    font-family: Tahoma, sans-serif;
    color:#dcdbd0;
    text-shadow: -2px -2px 0 #000, 2px -2px 0 #000, -2px 2px 0 #000, 2px 2px 0 #000;
}
.create-tree{
    display: flex;
    height: 70vh;
    align-items: center;
    justify-content: center;
}
.create-tree input{
  display: inline-block;
  padding: 12px 20px;
  margin: 8px 0;
  border: 1px solid rgb(14, 13, 13);
  border-radius: 4px;
  box-sizing: border-box;
}

form {
  width: 60vw;
  max-width: 500px;
  min-width: 300px;
  padding-bottom: 2em;
  background-color: rgba(255, 255, 255, 0.5);
  backdrop-blur: 10px;
}
fieldset {
  border: none;
  padding: 2rem 0;
}
label {
  display: block;
  margin: 0.5rem 0;
  color: rgb(9, 9, 7);
  font-weight: bold;
  font-family:Tahoma, sans-serif;
}
input,
textarea,
select {
  margin: 10px 0 0 0;
  width: 100%;
  min-height: 2em;
}
input, textarea {
  background-color: #635f2f;
  border: 1px solid #070707;
  color: #0e0e0e;
}
input[type="file"] {
  padding: 2px 2px;
}
#submit{
    font-weight: bold;
    color:#0e0e0e;
    font-family:Tahoma, sans-serif;
}



</style>