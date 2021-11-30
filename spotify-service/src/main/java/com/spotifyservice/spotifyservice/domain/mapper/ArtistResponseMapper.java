package com.spotifyservice.spotifyservice.domain.mapper;

import com.spotifyservice.spotifyservice.controller.response.ArtistResponse;
import com.spotifyservice.spotifyservice.domain.Artist;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ArtistResponseMapper implements Function<Artist, ArtistResponse> {

    public ArtistResponse apply(Artist artist){
        return ArtistResponse.builder()
                .id(artist.getIdArtist())
                .name(artist.getNameArtist())
                .genre(artist.getGenre())
                .image(artist.getImage())
                .build();
    }
}
