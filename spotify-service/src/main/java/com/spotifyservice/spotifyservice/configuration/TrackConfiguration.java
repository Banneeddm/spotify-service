package com.spotifyservice.spotifyservice.configuration;


import com.spotifyservice.spotifyservice.service.AlbumService;
import com.spotifyservice.spotifyservice.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;



@Configuration
public class TrackConfiguration {

    @Autowired
    private TrackService trackService;

    @Autowired
    private AlbumConfiguration albumConfiguration;

    @Autowired
    private AlbumService albumService;

}
