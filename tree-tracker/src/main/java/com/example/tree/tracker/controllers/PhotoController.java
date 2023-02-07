package com.example.tree.tracker.controllers;

import com.example.tree.tracker.Dao.PhotoDao;
import com.example.tree.tracker.model.Photo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class PhotoController {

    private final PhotoDao photoDao;

    public PhotoController(PhotoDao photoDao) {
        this.photoDao = photoDao;
    }

    @PostMapping
    public ResponseEntity<String> uploadPhoto(@RequestParam("photo")MultipartFile file){
        if(file.isEmpty()){
            return new ResponseEntity<>("Please select a file", HttpStatus.BAD_REQUEST);
        }
        try {
            photoDao.insertPhoto(file.getOriginalFilename(), file.getBytes());
            return new ResponseEntity<>("Photo uploaded successfully!", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
