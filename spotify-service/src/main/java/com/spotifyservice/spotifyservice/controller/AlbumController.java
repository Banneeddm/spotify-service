package com.spotifyservice.spotifyservice.controller;

import com.spotifyservice.spotifyservice.controller.request.AlbumRequest;
import com.spotifyservice.spotifyservice.domain.Album;
import com.spotifyservice.spotifyservice.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.lang.Long;

@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping(name = "/")
    public String initial(){
        return "Esto es un album";
    }

    @GetMapping("/{id}")
    public Album retriveAlbum(){
        return albumService.getAlbum();
    }

    @GetMapping("/")
    public List<Album> retriveAlbums(){
        return albumService.getAlbums();
    }

    @PostMapping(path = "/")
    public Album createAlbum(@RequestBody AlbumRequest album) {
        return albumService.createAlbum(album);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        return ResponseEntity.ok(Boolean.TRUE);
    }
}
