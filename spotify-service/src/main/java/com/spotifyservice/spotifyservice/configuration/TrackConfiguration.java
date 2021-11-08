package com.spotifyservice.spotifyservice.configuration;


import com.spotifyservice.spotifyservice.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;


@Configuration
public class TrackConfiguration {

    @Autowired
    private TrackService trackService;

    @PostConstruct
    public void initTrack(){
        trackService.initTrack();
    }

}
