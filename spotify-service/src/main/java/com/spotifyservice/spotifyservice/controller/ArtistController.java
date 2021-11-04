package com.spotifyservice.spotifyservice.controller;

import com.spotifyservice.spotifyservice.controller.request.ArtistRequest;
import com.spotifyservice.spotifyservice.domain.Artist;
import com.spotifyservice.spotifyservice.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping("/{id}")
    public Artist retriveArtist(@PathVariable Long id){
        return artistService.getArtist(id);
    }

    @GetMapping("/")
    public List<Artist> retriveArtists(){
        return artistService.getArtists();
    }

    @PostMapping(path = "/")
    public Artist createArtist(@RequestBody ArtistRequest artistRequest) {
        return artistService.createArtist(artistRequest);
    }
}
