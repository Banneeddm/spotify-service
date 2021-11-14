package com.spotifyservice.spotifyservice.controller;

import com.spotifyservice.spotifyservice.domain.Track;
import com.spotifyservice.spotifyservice.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spotify")
public class SpotifyController {

    @Autowired
    private TrackService trackService;

    @GetMapping()
    public String initial(){
        return "esto es spotify";
    }

    @GetMapping("/play/track/{id}")
    public Track playTrack(@PathVariable("id") Long id){
         return trackService.playTrack(id);
    }
}
