package com.spotifyservice.spotifyservice.repository;

import com.spotifyservice.spotifyservice.domain.Track;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Objects;

public interface TrackRepository extends CrudRepository<Track, Long> {

    public List<Track> findByNameTrack(String track);

    public Track findByIdTrack(Long id);
}
