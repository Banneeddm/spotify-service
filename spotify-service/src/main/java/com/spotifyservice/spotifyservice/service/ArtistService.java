package com.spotifyservice.spotifyservice.service;

import com.spotifyservice.spotifyservice.controller.request.ArtistRequest;
import com.spotifyservice.spotifyservice.domain.Artist;
import com.spotifyservice.spotifyservice.domain.ArtistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {


    @Autowired
    private ArtistMapper artistMapper;

    @Qualifier("artists")
    @Autowired
    private List<Artist> artists;

    @Qualifier("/{idArtist}")
    @Autowired
    private Artist artist;

    public Artist getArtist(Long id){
        return artist;
    }

    public List<Artist> getArtists(){
        return artists;
    }

    public Artist createArtist(ArtistRequest artistRequest){
        return artistMapper.apply(artistRequest);
    }

    public Artist getIdArtist(ArtistRequest artistRequest){
        return Artist.builder().build();
    }
}
