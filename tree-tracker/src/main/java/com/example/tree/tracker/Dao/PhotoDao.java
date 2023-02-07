package com.example.tree.tracker.Dao;

import com.example.tree.tracker.model.Photo;


import java.util.List;

public interface PhotoDao {

    public void insertPhoto(String name, byte[] data);

    List<Photo> getAllPhotos(int treeTag);

    Photo getOnePhoto(int treeTag);

}
