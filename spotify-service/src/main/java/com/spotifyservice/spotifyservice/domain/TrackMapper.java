package com.spotifyservice.spotifyservice.domain;

import com.spotifyservice.spotifyservice.controller.request.TrackRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TrackMapper implements Function<TrackRequest, Track> {

    @Override
    public Track apply(TrackRequest trackRequest){
        return Track.builder()
                .id(trackRequest.getId())
                .name(trackRequest.getName())
                .idArtist(trackRequest.getIdArtist())
                .idAlbum(trackRequest.getIdAlbum())
                .duration(trackRequest.getDuration())
                .reproduction(trackRequest.getReproduction()).build();
    }
}
