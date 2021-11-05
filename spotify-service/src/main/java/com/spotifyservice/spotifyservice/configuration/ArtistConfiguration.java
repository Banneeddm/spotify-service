package com.spotifyservice.spotifyservice.configuration;


import com.spotifyservice.spotifyservice.domain.Artist;
import com.spotifyservice.spotifyservice.domain.Track;
import com.spotifyservice.spotifyservice.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class ArtistConfiguration {

    @Autowired
    private TrackService trackService;

    Artist[] v = new Artist[5];

    Artist artis1 = new Artist(1L, "Artist1","Gen1","image");
    Artist artis2 = new Artist(2L, "Artist2","Gen2","image");
    Artist artis3 = new Artist(3L, "Artist3","Gen3","image");
    Artist artis4 = new Artist(4L, "Artist4","Gen4","image");
    Artist artis5 = new Artist(5L, "Artist5","Gen6","image");


    @Bean(name = "/{idArtist}")
    public Artist getArtis(){
        return artis1;
    }

    @Bean(name = "rank")
    public List<Artist> getArtist(){
        return Arrays.asList(artis1,artis2,artis3,artis4,artis5);
    }

    @Bean(name = "ArtistTracks")
    public List<Track> getTracks()
    {
        return trackService.getTracks();
    }

}
