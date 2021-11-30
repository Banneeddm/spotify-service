package com.spotifyservice.spotifyservice.service;


import com.spotifyservice.spotifyservice.controller.request.TrackRequest;
import com.spotifyservice.spotifyservice.controller.response.TrackResponse;
import com.spotifyservice.spotifyservice.domain.Track;

public interface ITrackService {

    public TrackResponse getTrack(Long id);

    public Iterable<Track> getTracks();

    public TrackResponse createTrack(TrackRequest trackRequest);

    public TrackResponse editTrack(Long id, TrackRequest trackRequest);

    public Track deleteTrack(Long id);


}
