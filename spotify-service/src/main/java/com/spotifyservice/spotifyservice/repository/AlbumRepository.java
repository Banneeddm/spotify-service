package com.spotifyservice.spotifyservice.repository;

import com.spotifyservice.spotifyservice.domain.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {

    List<Album> findByNameAlbum(String nameAlbum);

    Album findByIdAlbum(Long idAlbum);
}
