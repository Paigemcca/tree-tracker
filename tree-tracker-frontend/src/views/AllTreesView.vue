<template>
    <div class="all-tree-photo" id="all-tree-photo">
    <AllTrees />
</div>
</template>


<script>

import AllTrees from '../components/AllTrees.vue'
export default{
    name: "all-trees",
    components: {
        AllTrees
    }
}
</script>
<style>
.all-tree-photo{
  background-image: url('../assets/pinecone.jpg') ;
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center;
  position: absolute;
  top: 122px;
  left:0;
  right:0;
  bottom:0;
  width: 100%;
  height: 100%;
}
</style>