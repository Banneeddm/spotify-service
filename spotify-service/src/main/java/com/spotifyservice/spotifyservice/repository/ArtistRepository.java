package com.spotifyservice.spotifyservice.repository;

import com.spotifyservice.spotifyservice.domain.Artist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Long> {

    List<Artist> findByNameArtist(String nameArtist);

    Artist findByIdArtist(Long idArtist);
}
