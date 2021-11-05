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

    @GetMapping(path = "/")
    public String initial(){
        return "Esto es un artist";
    }

    @GetMapping("/{id}")
    public Artist retriveArtist(@PathVariable Long id){
        return artistService.getArtist(id);
    }

    @GetMapping("/rank")
    public List<Artist> retriveArtists(){
        return artistService.getArtists();
    }

    @PostMapping(path = "/")
    public Artist createArtist(@RequestBody ArtistRequest artistRequest) {
        return artistService.createArtist(artistRequest);
    }

    @GetMapping("/{id}/songs/rank")
    public List<Track> getTracks(){
        return artistService.getTracks();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        return ResponseEntity.ok(Boolean.TRUE);
    }


}
