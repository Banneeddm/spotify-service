package com.spotifyservice.spotifyservice.controller;

import com.spotifyservice.spotifyservice.controller.request.TrackRequest;
import com.spotifyservice.spotifyservice.controller.response.TrackResponse;
import com.spotifyservice.spotifyservice.domain.Track;
import com.spotifyservice.spotifyservice.service.ITrackService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/track")
public class TrackController {

    @Autowired
    private ITrackService trackService;

    //Track Initial.
    @GetMapping(path = "")
    public String initial(){
        return "Esto es un track";
    }

    //Filtrar por id.
    @GetMapping("/{id}")
    public TrackResponse retriveTrack(@PathVariable Long id){
        return trackService.getTrack(id);
    }

    //mostrar todos los tracks.
    @GetMapping("/")
    public Iterable<Track> retriveTracks(){
        return trackService.getTracks();
    }

    //Crear new track.
    @PostMapping(path = "/")
    public TrackResponse createTrack(@RequestBody TrackRequest trackRequest){
        return trackService.createTrack(trackRequest);
    }

    //Editar Track.
    @PutMapping("{id}")
    public TrackResponse editTrack(@PathVariable Long id, @RequestBody TrackRequest trackRequest){
        return trackService.editTrack(id, trackRequest);
    }

    //Borrar track.
    @DeleteMapping("/{id}")
    public Boolean deleteTrack(@PathVariable Long id){
        trackService.deleteTrack(id);
        return true;
    }
}
