<template>
    <div class="add-bg-photo" id="add-bg-photo">
    <AddTree />
    </div>
</template>

<script>
import AddTree from '@/components/AddTree.vue'

export default{
    components:{
        AddTree
    }
}

</script>

<style>
.add-bg-photo{
  background-image: url('../assets/bw-tree.jpg') ;
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