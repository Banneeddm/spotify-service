package com.spotifyservice.spotifyservice.domain.mapper;

import com.spotifyservice.spotifyservice.controller.request.ArtistRequest;
import com.spotifyservice.spotifyservice.domain.Artist;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ArtistMapper implements Function<ArtistRequest, Artist> {

    @Override
    public Artist apply(ArtistRequest artistRequest)
    {
        return Artist.builder()
                .idArtist(artistRequest.getIdArtist())
                .nameArtist(artistRequest.getName())
                .genre(artistRequest.getGenre())
                .image(artistRequest.getImage()).build();
    }
}
