package com.spotifyservice.spotifyservice.domain.mapper;


import com.spotifyservice.spotifyservice.controller.response.AlbumResponse;
import com.spotifyservice.spotifyservice.domain.Album;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AlbumResponseMapper implements Function<Album, AlbumResponse> {

    public AlbumResponse apply(Album album){
        return AlbumResponse.builder()
                .id(album.getIdAlbum())
                .name(album.getNameAlbum())
                .idArtist(album.getIdArtist().getIdArtist())
                .nameArtist(album.getIdArtist().getNameArtist())
                .generoArtist(album.getIdArtist().getGenre())
                .imageArtist(album.getIdArtist().getImage())
                .build();
    }
}
