import axios from 'axios';

const http = axios.create({
    baseURL : "http://localhost:9000"
})

export default {
    getAllTrees(){
        return http.get('/trees')
    },
    getOneTree(treeTag){
        return http.get(`/tree/${treeTag}`)
    },
    createTree(newTree){
        return http.post('/addtree', newTree)
    },
    addImage(treeTag, treeImage){
        return http.post(`/tree/${treeTag}`, treeImage)
    },
    
    }