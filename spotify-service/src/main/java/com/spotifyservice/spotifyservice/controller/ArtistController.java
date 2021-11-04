package com.spotifyservice.spotifyservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    @GetMapping("/")
    public String retriveArtist(){

        return "Esto es un artista.";
    }
}
