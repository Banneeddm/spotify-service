package com.spotifyservice.spotifyservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/track")
public class TrackController {

    @GetMapping("/")
    public String retriveTrack(){

        return "Esto es un track";
    }
}
