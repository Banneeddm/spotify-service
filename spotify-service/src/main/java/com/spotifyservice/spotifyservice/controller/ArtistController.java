package com.spotifyservice.spotifyservice.controller;

import com.spotifyservice.spotifyservice.controller.request.ArtistRequest;
import com.spotifyservice.spotifyservice.controller.response.ArtistResponse;
import com.spotifyservice.spotifyservice.domain.Artist;
import com.spotifyservice.spotifyservice.service.IArtistService;
import com.spotifyservice.spotifyservice.service.ITrackService;
import com.spotifyservice.spotifyservice.service.implementacion.ArtistService;
import com.spotifyservice.spotifyservice.service.implementacion.TrackService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    private IArtistService artistService;

    @Autowired
    private ITrackService trackService;

    //Pantalla initial.
    @GetMapping
    public String initial(){
        return "Esto es un artist";
    }

    //Filtra Artista por id.
    @GetMapping("/{id}")
    public ArtistResponse getArtist(@PathVariable("id") Long id){
        return artistService.getArtist(id);
    }

    //Muestra todos los artistas.
    @GetMapping("/")
    public Iterable<Artist> artists(){
        return artistService.getArtists();
    }


    //Crea un nuevo artista.
    @PostMapping(path = "/")
    public ArtistResponse createArtist(@RequestBody ArtistRequest artistRequest) {
        return artistService.createArtist(artistRequest);
    }

    //Modificar un artista existente.
    @PutMapping(path = "/{id}")
    public ArtistResponse editArtist(@PathVariable Long id, @RequestBody ArtistRequest artistRequest){
        return artistService.editArtist(id, artistRequest);
    }

    //Eliminar un Artista por id-
    @DeleteMapping("/{id}")
    public Boolean deleteArtist(@PathVariable Long id){
        artistService.deleteArtist(id);
        return true;
    }
}
