package com.techelevator.controller;

import com.techelevator.dao.PhotoDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

    @RestController
    @CrossOrigin
    @RequestMapping("/upload")
    public class PhotoController {

        private final PhotoDao photoDao;

        public PhotoController(PhotoDao photoDao) {
            this.photoDao = photoDao;
        }

        @PostMapping
        public ResponseEntity<String> uploadPhoto(@RequestParam("photo") MultipartFile file){
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

