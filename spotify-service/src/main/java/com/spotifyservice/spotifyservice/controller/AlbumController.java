package com.spotifyservice.spotifyservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/album")
public class AlbumController {

    @GetMapping("/")
    public String retriveAlbum(){

        return "Esto es un album.";
    }
}
