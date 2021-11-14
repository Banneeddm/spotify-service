package com.spotifyservice.spotifyservice.configuration;


import com.spotifyservice.spotifyservice.service.ArtistService;
import com.spotifyservice.spotifyservice.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ArtistConfiguration {

    @Autowired
    private TrackService trackService;

    @Autowired
    private ArtistService artistService;
}
