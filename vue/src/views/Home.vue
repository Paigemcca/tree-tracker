
<template>
  <div class="home-photo" id="bg-photo">
<about />
</div>
</template>

<script>


import About from '../components/AboutHome.vue';


export default {
name: 'HomeView',
components: {
About,

}
}
</script>

<style>
tree-list{
background-color: red;
}
router-link{
padding-top: 100px;
}
.home-photo{
background-image: url('../assets/lily-pond (2).jpg') ;
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