package com.spotifyservice.spotifyservice.repository;

import com.spotifyservice.spotifyservice.domain.Track;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrackRepository extends CrudRepository<Track, Long> {

    public List<Track> findByNameTrack(String track);

    public Track findByIdTrack(Long id);

    @Query(value = "SELECT * FROM TRACK WHERE ID_ALBUM = :idAlbum", nativeQuery = true)
    public Track traerAlbumTrack(Long idAlbum);

    @Query(value = "SELECT * FROM TRACK WHERE ID_ARTIST = :idArtist", nativeQuery = true)
    public Track traerArtistTrack(Long idArtist);
}
