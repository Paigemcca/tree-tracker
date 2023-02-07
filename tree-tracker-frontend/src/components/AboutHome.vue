<template>
    <div class="main">
    <h1>Welcome to Tree Tracker!</h1>
    <div class="main-text">
    <h2>How to use Tree Tracker</h2>
        <p id="first">Using the navigation bar at the top, you can navigate through the different functions of the website.<br>
            Currently Tree Tracker is keeping track of a tree's Tree Tag, description, health, and a poem.<br> 
        </p>
        <p>This is the home page. <br>
            By clicking "Trees" you can find all the trees you are currently tracking.<br>
            By clicking "Add Trees" you can find a form you can fill out to add a new tree.<br>
            By clicking "Update Tree" you can select a tree to edit the info. (not available yet).<br>
            By clicking "Tree Map" you can see where all your trees are located at the park. (this is not yet implemented).
        </p>
    </div>
    </div>
</template>

<style>
.main{
  background-color: rgb(246, 166, 100);
  padding: 0px 10px 10px 10px;
  border-radius: 10px;
  margin: 100px 250px 0px 70px;
  width: 50em;
  height: 18em;
  float: right;
  overflow: hidden;
  
}
.main-text{
    text-align: left;
}
h1{
    padding-top: 5px;
    text-align:center;
}
h2{
    margin-bottom: 10px;
}
#first{
    margin-top: 3px;
}
</style>