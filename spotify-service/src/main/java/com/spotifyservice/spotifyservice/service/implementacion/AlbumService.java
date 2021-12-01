package com.spotifyservice.spotifyservice.service.implementacion;

import com.spotifyservice.spotifyservice.configuration.exceptions.CustomException;
import com.spotifyservice.spotifyservice.controller.request.AlbumRequest;
import com.spotifyservice.spotifyservice.controller.response.AlbumResponse;
import com.spotifyservice.spotifyservice.domain.Album;
import com.spotifyservice.spotifyservice.domain.Track;
import com.spotifyservice.spotifyservice.domain.mapper.AlbumMapper;
import com.spotifyservice.spotifyservice.domain.Artist;
import com.spotifyservice.spotifyservice.domain.mapper.AlbumResponseMapper;
import com.spotifyservice.spotifyservice.repository.AlbumRepository;
import com.spotifyservice.spotifyservice.repository.ArtistRepository;
import com.spotifyservice.spotifyservice.repository.TrackRepository;
import com.spotifyservice.spotifyservice.service.IAlbumService;
import com.spotifyservice.spotifyservice.service.IArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AlbumService implements IAlbumService {


    List<Album> listaAlbums = new ArrayList<Album>();

    @Autowired
    private IArtistService artistService;

    @Autowired
    private AlbumMapper albumMapper;

    @Autowired
    private AlbumResponseMapper albumResponseMapper;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private TrackRepository trackRepository;


    public AlbumResponse getAlbum(Long id){
        Album album = albumRepository.findByIdAlbum(id);
        if(album == null){
            throw new CustomException("No hay ningun album registrado con ese ID...");
        }
        return albumResponseMapper.apply(album);
    }

    public Iterable<Album> getAlbums(){
        return albumRepository.findAll();
    }

    public AlbumResponse createAlbum(AlbumRequest albumRequest){
        if(albumRequest.getName() == null){
            throw new CustomException("Llene los campos correctamente");
        }
        Album album = albumMapper.apply(albumRequest);
        Artist artist = artistRepository.findByIdArtist(album.getIdArtist().getIdArtist());
        if(artist == null){
            throw new CustomException("Artista no encontrado. Los artistas registrados son: " +
                    artistRepository.findAll());
        }
        album.setIdArtist(artist);
        albumRepository.save(album);
        return albumResponseMapper.apply(album);
    }

    public AlbumResponse editAlbum(Long id, AlbumRequest albumRequest){
        Album album = albumRepository.findByIdAlbum(id);
        if(album == null){
            throw new CustomException("El album seleccionado no existe..");
        }
        if(albumRequest.getName() != null){album.setNameAlbum(albumRequest.getName());}
        if(albumRequest.getIdArtist() != null){
            Artist artist = artistRepository.findByIdArtist(albumRequest.getIdArtist().getIdArtist());
            if(artist == null){
                throw new CustomException("El artist seleccionado no existe..");
            }
            album.setIdArtist(artist);
        }
        albumRepository.save(album);
        return albumResponseMapper.apply(album);
    }

    public Boolean deleteAlbum(Long id){
        Album album = albumRepository.findByIdAlbum(id);
        if(album == null){
            throw new CustomException("Album no encontrado");
        }
        Track track = trackRepository.traerAlbumTrack(id);
        if(track.getIdAlbum().getIdAlbum().equals(id)){
            track.setIdAlbum(null);
        }
        if(album.getIdArtist() == null){
            albumRepository.delete(album);
            return true;
        }
        List<Album> albumList = albumRepository.masDeDosAlbumsUnArtist(album.getIdArtist().getIdArtist());
        for(Album album1: albumList){
            if(album1.getIdAlbum().equals(id)){
                album1.setIdArtist(null);
                albumRepository.delete(album1);
                return true;
            }
        }
        return false;
    }

    public void setArtistNull(Long idArtist){
        List<Album> albumList = albumRepository.masDeDosAlbumsUnArtist(idArtist);
        for(Album album: albumList){
            album.setIdArtist(null);
            albumRepository.save(album);
        }
    }
}
