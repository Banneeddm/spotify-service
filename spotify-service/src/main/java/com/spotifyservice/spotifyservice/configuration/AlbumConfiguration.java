package com.spotifyservice.spotifyservice.configuration;
import com.spotifyservice.spotifyservice.service.AlbumService;
import com.spotifyservice.spotifyservice.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;


@Configuration
public class AlbumConfiguration {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private ArtistService artistService;


    @PostConstruct
    public void init(){
        albumService.initAlbum(artistService.initArtist());
    }
}
