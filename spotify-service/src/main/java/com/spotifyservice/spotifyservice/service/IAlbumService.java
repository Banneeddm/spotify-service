package com.spotifyservice.spotifyservice.service;

import com.spotifyservice.spotifyservice.controller.request.AlbumRequest;
import com.spotifyservice.spotifyservice.controller.response.AlbumResponse;
import com.spotifyservice.spotifyservice.domain.Album;

public interface IAlbumService {

    public AlbumResponse getAlbum(Long id);

    public Iterable<Album> getAlbums();

    public AlbumResponse createAlbum(AlbumRequest albumRequest);

    public AlbumResponse editAlbum(Long id, AlbumRequest albumRequest);

    public Boolean deleteAlbum(Long id);
}
