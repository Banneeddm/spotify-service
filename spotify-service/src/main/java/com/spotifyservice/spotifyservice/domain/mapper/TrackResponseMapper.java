package com.spotifyservice.spotifyservice.domain.mapper;

import com.spotifyservice.spotifyservice.controller.response.TrackResponse;
import com.spotifyservice.spotifyservice.domain.Track;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TrackResponseMapper implements Function<Track, TrackResponse> {

    public TrackResponse apply(Track track){
        return TrackResponse.builder()
                .id(track.getIdTrack())
                .name(track.getNameTrack())
                .idArtist(track.getIdArtist().getIdArtist())
                .nameArtist(track.getIdArtist().getNameArtist())
                .idAlbum(track.getIdAlbum().getIdAlbum())
                .nameAlbum(track.getIdAlbum().getNameAlbum())
                .reproduction(track.getReproduction())
                .duration(track.getDuration())
                .build();
    }
}
