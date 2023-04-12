package com.techelevator.dao;

import com.techelevator.model.Tree;

import java.util.List;

public interface TreeDao {
    List<Tree> getAllTrees();

    Tree getOneTree(int treeTag);

    void createTree(Tree tree);

    //void uploadImage(int treeTag, byte[] data);
}
