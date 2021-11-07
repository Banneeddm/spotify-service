package com.spotifyservice.spotifyservice.configuration;


import com.spotifyservice.spotifyservice.service.ArtistService;
import com.spotifyservice.spotifyservice.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class ArtistConfiguration {

    @Autowired
    private TrackService trackService;

    @Autowired
    private ArtistService artistService;

    @PostConstruct
    public void initArtist(){
        artistService.initArtist();
    }

}
