package com.spotifyservice.spotifyservice.controller;

import com.spotifyservice.spotifyservice.controller.request.TrackRequest;
import com.spotifyservice.spotifyservice.domain.Track;
import com.spotifyservice.spotifyservice.service.TrackService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/track")
public class TrackController {

    @Autowired
    private TrackService trackService;

    //Track Initial.
    @GetMapping(path = "")
    public String initial(){
        return "Esto es un track";
    }

    //Filtrar por id.
    @GetMapping("/{id}")
    public Track retriveTrack(@PathVariable Long id){
        return trackService.getTrack(id);
    }

    //mostrar todos los tracks.
    @GetMapping("/")
    public Iterable<Track> retriveTracks(){
        return trackService.getTracks();
    }

    //Crear new track.
    @PostMapping(path = "/")
    public Track createTrack(@RequestBody TrackRequest trackRequest){
        return trackService.createTrack(trackRequest);
    }

    //Editar Track.
    @PutMapping("{id}")
    public Track editTrack(@PathVariable Long id, @RequestBody TrackRequest trackRequest){
        return trackService.editTrack(id, trackRequest);
    }

    //Borrar track.
    @DeleteMapping("/{id}")
    public String deleteTrack(@PathVariable Long id){
        trackService.deleteTrack(id);
        return "Track eliminado con exito";
    }
}
