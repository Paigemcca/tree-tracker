<template>
     <div class="navbar">
    <img :src="require('../assets/logo rosicrucian museum.png')" alt="logo">
    <a href="/">Home</a>
    <a href="/trees">Trees</a>
    <a href="/addtree">Add Tree</a>
    <a href="">Update Tree</a>
    <a href="">Tree Map</a>
    <!-- <div class ="menu-item"><router-link to="/addtree">add</router-link></div> -->
    </div>


</template>

<style>
body{
  margin:0;
  padding: 0;
}
.navbar{
  overflow: hidden;
  background-color: rgb(135, 161, 247);
  position: fixed;
  top: 0;
  width: 100%;
  height: 122px;
}
.navbar a{
  float: left;
  display: block;
  color: aliceblue;
  text-align: center;
  padding: 45px 16px;
  text-decoration: none;
  font-size: 20px;
}

.navbar a:hover{
  background: aliceblue;
  color: black;
}
.navbar img{
  float: left;
  padding-right: 15px;
  padding-left: 5px;
  padding-top:5px;
}
@media (max-width: 600px) {
  .navbar a {
    padding: 15px 8px;
    font-size: 16px;
  }
  @media (max-width: 600px) {
  .navbar img {
    width: 150px;
  }
}
}
</style>