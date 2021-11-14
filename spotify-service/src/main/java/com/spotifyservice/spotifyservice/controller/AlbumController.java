package com.spotifyservice.spotifyservice.controller;

import com.spotifyservice.spotifyservice.controller.request.AlbumRequest;
import com.spotifyservice.spotifyservice.domain.Album;
import com.spotifyservice.spotifyservice.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Album retriveAlbum(@PathVariable("id") Long id){
        return albumService.getAlbum(id);
    }

    //Muestra todos los Albumes.
    @GetMapping("/")
    public Iterable<Album> retriveAlbums(){
        return albumService.getAlbums();
    }

    //Crea un nuevo album.
    @PostMapping(path = "/")
    public Album createAlbum(@RequestBody AlbumRequest album) {
        return albumService.createAlbum(album);
    }

    //Modifica un Album existente.
    @PutMapping(path = "/{id}")
    public Album editAlbum(@PathVariable Long id, @RequestBody AlbumRequest albumRequest){
        return albumService.editAlbum(id, albumRequest);
    }

    //Elimina un album existente.
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        albumService.deleteAlbum(id);
        return "Album Eliminado con exito";
    }
}
