package com.spotifyservice.spotifyservice.service;

import com.spotifyservice.spotifyservice.controller.request.AlbumRequest;
import com.spotifyservice.spotifyservice.domain.Album;
import com.spotifyservice.spotifyservice.domain.AlbumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private AlbumMapper albumMapper;

    @Qualifier("albums")
    @Autowired
    private List<Album> albums;

    @Qualifier("/{idAlbum}")
    @Autowired
    private Album album;

    public Album getAlbum(Long id){
        return album;
    }

    public List<Album> getAlbums(){
        return albums;
    }

    public Album createAlbum(AlbumRequest request){
        return albumMapper.apply(request);
    }

    public Album getidAlbum(AlbumRequest albumRequest){
        return Album.builder().idAlbum(albumRequest.getIdAlbum()).build();
    }
}
