package com.spotifyservice.spotifyservice.controller;

import com.spotifyservice.spotifyservice.controller.request.TrackRequest;
import com.spotifyservice.spotifyservice.domain.Track;
import com.spotifyservice.spotifyservice.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/track")
public class TrackController {

    @Autowired
    private TrackService trackService;

    @GetMapping(path = "/")
    public String initial(){
        return "Esto es un track";
    }

    @GetMapping("/{id}")
    public Track retriveTrack(@PathVariable Long id){
        return trackService.getTrack(id);
    }

    @GetMapping("/rank")
    public List<Track> retriveTracks(){
        return trackService.getTracks();
    }

    @PostMapping(path = "/")
    public Track createTrack(@RequestBody TrackRequest trackRequest){
        return trackService.createTrack(trackRequest);
    }
}
