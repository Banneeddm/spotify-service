package com.spotifyservice.spotifyservice.controller;

import com.spotifyservice.spotifyservice.controller.request.ArtistRequest;
import com.spotifyservice.spotifyservice.domain.Artist;
import com.spotifyservice.spotifyservice.domain.Track;
import com.spotifyservice.spotifyservice.service.ArtistService;
import com.spotifyservice.spotifyservice.service.TrackService;
import io.micrometer.core.ipc.http.HttpSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Retention;
import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @Autowired
    private TrackService trackService;

    //Pantalla initial.
    @GetMapping
    public String initial(){
        return "Esto es un artist";
    }

    //Filtra Artista por id.
    @GetMapping("/{id}")
    public List<Artist> getArtist(@PathVariable("id") Long id){
        return artistService.getArtist(id);
    }

    //Muestra todos los artistas.
    @GetMapping("/")
    public List<Artist> artists(){
        return artistService.getArtists();
    }

    //Muestra un rank de artistias --> Hacer de new.
    @GetMapping("/rank")
    public List<Artist> retriveArtists(){
        return artistService.getArtists();
    }

    //Crea un nuevo artista.
    @PostMapping(path = "/")
    public List<Artist> createArtist(@RequestBody ArtistRequest artistRequest) {
        return artistService.createArtist(artistRequest);
    }

    //Filta por id, las canciones mas escuchadas --> Replantear.
    @GetMapping("/{id}/songs/rank")
    public List<Track> getTracks(){
        return artistService.getTracks();
    }
}
