package com.spotifyservice.spotifyservice.service;

import com.spotifyservice.spotifyservice.controller.request.TrackRequest;
import com.spotifyservice.spotifyservice.domain.Track;
import com.spotifyservice.spotifyservice.domain.TrackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackService {

    @Autowired
    private TrackMapper trackMapper;

    @Qualifier("ranks")
    @Autowired
    private List<Track> tracks;

    @Qualifier("/{idTrack}")
    @Autowired
    private Track track;

    public Track getTrack(Long id)
    {
        return track;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public Track createTrack(TrackRequest trackRequest){
        return trackMapper.apply(trackRequest);
    }
}
