package com.spotifyservice.spotifyservice.configuration;

import com.spotifyservice.spotifyservice.domain.Album;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;



@Configuration
public class AlbumConfiguration {

    Album album1 = new Album(1L, 1L, "album1");
    Album album2 = new Album(2L,2L,"Album2");
    Album album3 = new Album(3L,3L,"Album3");
    Album album4 = new Album(4L,4L,"Album4");
    Album album5 = new Album(5L,5L,"Album5");

    @Bean(name = "/{idAlbum}")
    public Album getAlbum(){
        return album1;
    }


    @Bean(name = "albums")
    public List<Album> getAlbums(){
        return Arrays.asList(album1,album2,album3,album4,album5);
    }

}
