package com.spotifyservice.spotifyservice.domain;

import com.spotifyservice.spotifyservice.controller.request.AlbumRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AlbumMapper implements Function<AlbumRequest, Album> {

    @Override
    public Album apply(AlbumRequest albumRequest){
        return Album.builder().idAlbum(albumRequest.getIdAlbum())
                .idArtist(albumRequest.getIdArtist())
                .nameAlbum(albumRequest.getName())
                .build();
    }
}
