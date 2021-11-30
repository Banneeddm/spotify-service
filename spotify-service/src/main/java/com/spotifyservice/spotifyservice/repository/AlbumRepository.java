package com.spotifyservice.spotifyservice.repository;

import com.spotifyservice.spotifyservice.controller.response.AlbumResponse;
import com.spotifyservice.spotifyservice.domain.Album;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {

    List<Album> findByNameAlbum(String nameAlbum);

    Album findByIdAlbum(Long idAlbum);

    @Query(value = "SELECT * FROM ALBUM WHERE ID_ARTIST = ID_ARTIST",nativeQuery = true)
    List<Album> masDeDosAlbumsUnArtist(Long ID_ARTIST);
}
