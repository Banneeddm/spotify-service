package com.spotifyservice.spotifyservice.service;

import com.spotifyservice.spotifyservice.controller.request.AlbumRequest;
import com.spotifyservice.spotifyservice.domain.Album;
import com.spotifyservice.spotifyservice.domain.AlbumMapper;
import com.spotifyservice.spotifyservice.domain.Artist;
import com.spotifyservice.spotifyservice.domain.Track;
import com.spotifyservice.spotifyservice.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AlbumService {


    List<Album> listaAlbums = new ArrayList<Album>();

    @Autowired
    private TrackService trackService;

    @Autowired
    private ArtistService artistService;

    @Autowired
    private AlbumMapper albumMapper;

    @Autowired
    private AlbumRepository albumRepository;

    public void initAlbum(Artist artist){
        if (listaAlbums.isEmpty()) {
            AlbumRequest album1 = new AlbumRequest();
            album1.setIdArtist(artist);
            album1.setName("Album1");
            createPrimerAlbum(album1);

            listaAlbums.stream().forEach(album -> {
                albumRepository.save(album);
            });
        }
    }

    public Album getPrimerAlbum(){
        return albumRepository.findByIdAlbum(1L);
    }

    public Album getAlbum(Long id){
        return albumRepository.findByIdAlbum(id);
    }

    public Iterable<Album> getAlbums(){
        return albumRepository.findAll();
    }

    public Album createPrimerAlbum(AlbumRequest request){
        Album album = albumMapper.apply(request);
        albumRepository.save(albumMapper.apply(request));
        return album;
    }

    public Album createAlbum(AlbumRequest albumRequest){
        Album albumNew = null;
        Album album = albumMapper.apply(albumRequest);
        for(Artist artist: artistService.getArtists()){
            if(artist.getIdArtist().equals(albumRequest.getIdArtist().getIdArtist())){
                albumNew = album;
                albumNew.setIdArtist(artist);
                albumRepository.save(albumNew);
            }
        }
        return albumNew;
    }

    public Album editAlbum(Long id, AlbumRequest albumRequest){
        Album albumActualizado = null;

        for(Album album: albumRepository.findAll()){
            if(album.getIdAlbum().equals(id)){
                albumActualizado = album;
            }
        }

        if(albumRequest.getName() != null){albumActualizado.setNameAlbum(albumRequest.getName());}
        for(Artist artist: artistService.getArtists()){
            if(artist.getIdArtist().equals(albumRequest.getIdArtist().getIdArtist())){
                albumActualizado.setIdArtist(artist);
            }
        }

        albumRepository.save(albumActualizado);

        return albumActualizado;
    }

    public Album deleteAlbum(Long id){
        Artist art = null;
        trackService.setAlbumNull(id);
        for(Artist artist: artistService.getArtists()){
            if(artist.getIdArtist().equals(albumRepository.findByIdAlbum(id).getIdArtist().getIdArtist())){
                art = artist;
                albumRepository.deleteById(id);
                artistService.guardarArtist(art);
            }
        }
        if(albumRepository.findByIdAlbum(id) != null){
            albumRepository.deleteById(id);
        }
        return null;
    }

    public void setArtistNull(Long idArtist){
        for(Album album:albumRepository.findAll()){
            if(album.getIdArtist().getIdArtist().equals(idArtist)){
                album.setIdArtist(null);
            }
        }
    }

    public Album guardarAlbum(Album album){
        albumRepository.save(album);
        return album;
    }
}
