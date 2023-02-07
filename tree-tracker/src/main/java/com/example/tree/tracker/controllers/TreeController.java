package com.example.tree.tracker.controllers;

import com.example.tree.tracker.Dao.TreeDao;
import com.example.tree.tracker.model.Tree;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TreeController {

    private TreeDao treeDao;

    public TreeController(TreeDao treeDao){
        this.treeDao = treeDao;
    }

    @RequestMapping(path = "/trees" , method = RequestMethod.GET)
    public List<Tree> getAllTrees(){
        return this.treeDao.getAllTrees();
    }

    @RequestMapping(path = "/tree/{treeTag}", method = RequestMethod.GET)
    public List<Tree> getOneTree(@PathVariable int treeTag){
        return (List<Tree>) this.treeDao.getOneTree(treeTag);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/addtree" , method = RequestMethod.POST)
    public void createTree(@Valid @RequestBody Tree newTree) {treeDao.createTree(newTree);}


}
