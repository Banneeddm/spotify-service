package com.spotifyservice.spotifyservice.service;


import com.spotifyservice.spotifyservice.controller.request.TrackRequest;
import com.spotifyservice.spotifyservice.domain.Track;

public interface ITrackService {

    public Track getTrack(Long id);

    public Iterable<Track> getTracks();

    public Track createTrack(TrackRequest trackRequest);

    public Track editTrack(Long id, TrackRequest trackRequest);

    public Track deleteTrack(Long id);


}
