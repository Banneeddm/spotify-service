package com.spotifyservice.spotifyservice.domain.mapper;

import com.spotifyservice.spotifyservice.controller.request.TrackRequest;
import com.spotifyservice.spotifyservice.domain.Track;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TrackMapper implements Function<TrackRequest, Track> {

    @Override
    public Track apply(TrackRequest trackRequest){
        return Track.builder()
                .idTrack(trackRequest.getId())
                .nameTrack(trackRequest.getName())
                .idArtist(trackRequest.getIdArtist())
                .idAlbum(trackRequest.getIdAlbum())
                .duration(trackRequest.getDuration())
                .reproduction(trackRequest.getReproduction()).build();
    }
}
