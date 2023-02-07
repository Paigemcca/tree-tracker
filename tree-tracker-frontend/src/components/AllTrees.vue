<template>

<input
      class="search-bar-tool"
      type="text"
      name="search"
      placeholder="search"
      src="src/assets/beige magnifying.png" 
      v-model="userInput"
      v-on:keyup.enter="searchComics"
    />

<div class="grid-container" id="card-body">
<div class="card" id="card-item" v-for="tree in trees" v-bind:key="tree.treeTag">
    <div class="card-image"> <img src='../assets/logo.png'/></div>
    <div class="tree-tag"> {{tree.treeTag}} </div>
    <div class="description"> {{tree.treeDesc}}
        <div class="health">{{tree.treeHealth}}</div>
    </div>
</div>
</div>
</template>

<script>
import TreeService from '@/services/TreeService'

export default {
  data(){
        return {
          trees: [],
          userInput: "",
            // tree:{
            //     treeId: 0,
            //     treeTag: 0,
            //     treeDesc: "",
            //     treeHealth: "",
            //     treePoem: "",
            // },
        }
    },
    created(){
      TreeService.getAllTrees(this.$route.params.treeTag).then((response) =>{
        this.trees = response.data;
      })
    },
    computed:{
      sortTrees(){
        return this.tree.filter((tree) =>
        tree.treeTag)
      }
    },
    methods:{
      searchTrees(){
        TreeService.getOneTree(this.userInput).then((response)=>{
          this.trees = response.data;
        });
      }
    }
}
</script>

<style>

/* for search bar */
.search-bar-tool[type="text"] {
  width: 15%;
  height: 40px;
  background-color: #ebc788;
  font-family: "Georgia", sans-serif;
  font-weight: bold;
  text-transform: uppercase;
  text-align: center;
  border: 4px solid;
  border-radius: 0px;
  border-image: linear-gradient(#eacca4, #d87824) 1;
  border-style: double;
  background-color: white;
  color: white;
  -webkit-transition: width 0.4s ease-in-out;
  transition: width 0.4s ease-in-out;
  padding: 5.5px;
  background-image: url(https://i.imgur.com/mcDRNUe.png);
  background-size: contain;
  background-repeat: no-repeat;
  outline: 0;
  background-size: 30px;
  background-position: 12px;
  flex-direction: row;
  display: flex;
  align-self: center;
  justify-content: center;
  margin-top: 5%;
  margin-bottom: 5%;
  margin-left: auto;
  margin-right: auto;
} 

/* Search Bar */
/* When the input field gets focus, change its width to 100% - need to change */
.search-bar-tool[type="text"]:focus {
  width: 18%;
  background-color: #e6dac6;
  font-family: "Tahoma", sans-serif;
  font-weight: bold;
  text-transform: uppercase;
  border-image: linear-gradient(#eacca4, #d87824) 1;
  text-align: center;
  border: 5px (#eacca4, #d87824);
  border-style: inset;
  border-radius: 0px;
  background-color: white;
  color: rgb(15, 15, 15);
} 
input.search-bar-tool {
  align-items: center;
}

::placeholder {
  /* "Search bar placeholder"*/
  color: rgb(7, 1, 1);
  font-family: "Georgia", "sans-serif";
}

/* for class card */
.card {
  width: 190px;
  height: 274px;
  background: rgb(246, 179, 64);
  border-radius: 6px;
  margin-left: auto;
  margin-right: auto;
}

.card-image img{
  background-color: rgb(145, 171, 238);
  width: 100%;
  height: 60%;
  border-radius: 6px 6px 0 0;
}

.card-image:hover {
  transform: scale(0.98);
}

.tag {
  text-transform: uppercase;
  font-size: 0.7em;
  font-weight: 600;
  color: rgb(63, 121, 230);
  padding: 10px 7px 0;
}

.tag:hover {
  cursor: pointer;
}

.description {
  font-weight: 600;
  color: rgb(88, 87, 87);
  padding: 7px;
}

.description:hover {
  cursor: pointer;
}

.health {
  color: gray;
  font-weight: 400;
  font-size: 11px;
  padding-top: 15px;
  padding-bottom: 5px;
}

.grid-container {
  display: grid;
  grid-template-columns: 250px 250px 250px 250px 250px;
  grid-template-rows: 450px 450px 450px 450px 450px ;
  justify-content: center;
  padding-top: 1px;
  height: auto;
  overflow: hidden;
}
</style>