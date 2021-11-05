package com.spotifyservice.spotifyservice.service;

import com.spotifyservice.spotifyservice.controller.request.ArtistRequest;
import com.spotifyservice.spotifyservice.domain.Artist;
import com.spotifyservice.spotifyservice.domain.ArtistMapper;
import com.spotifyservice.spotifyservice.domain.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ArtistService {

    @Autowired
    private ArtistMapper artistMapper;


    @Qualifier("rank")
    @Autowired
    private List<Artist> artists;

    @Qualifier("ArtistTracks")
    @Autowired
    private List<Track> tracks;


    @Qualifier("/{idArtist}")
    @Autowired
    private Artist artist;

    public void calcularCantidadArtist()
    {
    }
    public Artist getArtist(){
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
    public List<Track> getTracks(){
        return tracks;
    }

}
