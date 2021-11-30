package com.spotifyservice.spotifyservice.service;


import com.spotifyservice.spotifyservice.controller.request.ArtistRequest;
import com.spotifyservice.spotifyservice.domain.Artist;

public interface IArtistService {

    public Artist getArtist(Long id);

    public Iterable<Artist> getArtists();

    public Artist createArtist(ArtistRequest artistRequest);

    public Artist editArtist(Long id, ArtistRequest artistRequest);

    public Artist deleteArtist(Long id);

    public Boolean guardarArtist(Artist artist);

}
