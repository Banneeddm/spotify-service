package com.spotifyservice.spotifyservice.controller;

import com.spotifyservice.spotifyservice.controller.request.AlbumRequest;
import com.spotifyservice.spotifyservice.domain.Album;
import com.spotifyservice.spotifyservice.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping("/{id}")
    public Album retriveAlbum(@PathVariable Long id){
        return albumService.getAlbum(id);
    }

    @GetMapping("/")
    public List<Album> retriveAlbums(){
        return albumService.getAlbums();
    }

    @PostMapping(path = "/")
    public Album createAlbum(@RequestBody AlbumRequest album) {
        return albumService.createAlbum(album);
    }
}
