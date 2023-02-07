package com.example.tree.tracker.Dao;

import com.example.tree.tracker.model.Tree;

import java.util.List;

public interface TreeDao {
    List<Tree> getAllTrees();

    Tree getOneTree(int treeTag);

    void createTree(Tree tree);

    //void uploadImage(int treeTag, byte[] data);
}
