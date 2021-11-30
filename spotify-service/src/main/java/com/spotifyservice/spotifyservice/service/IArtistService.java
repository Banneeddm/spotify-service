package com.spotifyservice.spotifyservice.service;


import com.spotifyservice.spotifyservice.controller.request.ArtistRequest;
import com.spotifyservice.spotifyservice.controller.response.ArtistResponse;
import com.spotifyservice.spotifyservice.domain.Artist;

public interface IArtistService {

    public ArtistResponse getArtist(Long id);

    public Iterable<Artist> getArtists();

    public ArtistResponse createArtist(ArtistRequest artistRequest);

    public ArtistResponse editArtist(Long id, ArtistRequest artistRequest);

    public Boolean deleteArtist(Long id);
}
