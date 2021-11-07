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

    //Pantalla inicial.
    @GetMapping(name = "/")
    public String initial(){
        return "Esto es un album";
    }

    //Filtrar por id.
    @GetMapping("/{id}")
    public List<Album> retriveAlbum(@PathVariable("id") Long id){
        return albumService.getAlbum(id);
    }

    //Muestra todos los Albumes.
    @GetMapping("/")
    public List<Album> retriveAlbums(){
        return albumService.getAlbums();
    }

    //Crea un nuevo album.
    @PostMapping(path = "/")
    public List<Album> createAlbum(@RequestBody AlbumRequest album) {
        return albumService.createAlbum(album);
    }

    //Elimina un album existente.
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        return ResponseEntity.ok(Boolean.TRUE);
    }
}
