<template>
    <div>
        <h1>Trees</h1>
        <table>
            <tr>
                <th>Tree Tag</th>
                <th>Description</th>
                <th>Tree Health</th>
            </tr>
            <tr v-for="tree in trees" v-bind:key="tree.treeId">
                <td>{{ tree.treeTag }}</td>
                <td>{{ tree.treeDesc }}</td>
                <td>{{ tree.treeHealth }}</td>
  
            </tr>
        </table>
    </div>
  </template>
  
  <script>
  import treeService from '../services/TreeService.js';
  export default {
      name: 'tree-list',
      data(){
          return {
              trees: []
          }
      },
      created(){
          treeService.getAllTrees().then(response => {
                  this.trees = response.data;
          })
      }
  
  }
  </script>
  
  <style>
  h1{
      padding-top: 100px;
  }
  
  </style>
  