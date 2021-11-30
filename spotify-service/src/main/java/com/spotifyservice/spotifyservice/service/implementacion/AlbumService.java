package com.spotifyservice.spotifyservice.service.implementacion;

import com.spotifyservice.spotifyservice.configuration.exeptions.CustomException;
import com.spotifyservice.spotifyservice.configuration.exeptions.NullPointerException;
import com.spotifyservice.spotifyservice.controller.request.AlbumRequest;
import com.spotifyservice.spotifyservice.controller.response.AlbumResponse;
import com.spotifyservice.spotifyservice.domain.Album;
import com.spotifyservice.spotifyservice.domain.mapper.AlbumMapper;
import com.spotifyservice.spotifyservice.domain.Artist;
import com.spotifyservice.spotifyservice.domain.mapper.AlbumResponseMapper;
import com.spotifyservice.spotifyservice.repository.AlbumRepository;
import com.spotifyservice.spotifyservice.repository.ArtistRepository;
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


    public AlbumResponse getAlbum(Long id){
        Album album = albumRepository.findByIdAlbum(id);
        if(album == null){
            throw new CustomException("No hay ningun album registrado con ese ID...");
        }
        AlbumResponse albumResponse = albumResponseMapper.apply(album);
        return albumResponse;
    }

    public Iterable<Album> getAlbums(){
        return albumRepository.findAll();
    }

    public AlbumResponse createAlbum(AlbumRequest albumRequest){
        Album album = albumMapper.apply(albumRequest);
        Artist artist = artistRepository.findByIdArtist(album.getIdArtist().getIdArtist());
        if(artist == null){
            throw new CustomException("Artista no encontrado. Los artistas registrados son: " +
                    artistRepository.findAll());
        }
        album.setIdArtist(artist);
        albumRepository.save(album);
        AlbumResponse albumResponse = albumResponseMapper.apply(album);
        return albumResponse;
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
        AlbumResponse albumResponse = albumResponseMapper.apply(album);

        return albumResponse;
    }

    public Boolean deleteAlbum(Long id){
        Album album = albumRepository.findByIdAlbum(id);
        if(album == null){
            throw new CustomException("Album no encontrado");
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
        for(Album album:albumRepository.findAll()){
            if(album.getIdArtist().getIdArtist().equals(idArtist)){
                album.setIdArtist(null);
            }
        }
    }
}
