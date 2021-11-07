package com.spotifyservice.spotifyservice.service;

import com.spotifyservice.spotifyservice.controller.request.AlbumRequest;
import com.spotifyservice.spotifyservice.domain.Album;
import com.spotifyservice.spotifyservice.domain.AlbumMapper;
import com.spotifyservice.spotifyservice.domain.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class AlbumService {


    List<Album> listaAlbums = new ArrayList<Album>();
    ArtistService artistService;


    @Autowired
    private AlbumMapper albumMapper;

    public void initAlbum(){
        if (listaAlbums.isEmpty()) {
            AlbumRequest album1 = new AlbumRequest();
            album1.setIdAlbum(1L);
            album1.setIdArtist(1L);
            album1.setName("Album1");

            createAlbum(album1);
        }
    }

    public List<Album> getAlbum(Long id){
        return listaAlbums.stream().filter(x -> Objects.equals(x.getIdAlbum(), id)).collect(Collectors.toList());
    }

    public List<Album> getAlbums(){
        return listaAlbums;
    }

    public List<Album> createAlbum(AlbumRequest request){
        listaAlbums.add(albumMapper.apply(request));
        return listaAlbums;
    }
}
