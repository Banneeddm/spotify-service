package com.spotifyservice.spotifyservice.service.implementacion;

import com.spotifyservice.spotifyservice.controller.request.ArtistRequest;
import com.spotifyservice.spotifyservice.domain.Artist;
import com.spotifyservice.spotifyservice.domain.mapper.ArtistMapper;
import com.spotifyservice.spotifyservice.repository.ArtistRepository;
import com.spotifyservice.spotifyservice.service.IArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistService implements IArtistService {

    List<Artist> listaArtist = new ArrayList<Artist>();

    @Autowired
    private TrackService trackService;

    @Autowired
    private ArtistMapper artistMapper;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private ArtistRepository artistRepository;


    public Artist getArtist(Long id){
        return artistRepository.findByIdArtist(id);
    }

    public Iterable<Artist> getArtists(){
        return artistRepository.findAll();
    }

    public Artist createArtist(ArtistRequest artistRequest){
        Artist artist = artistMapper.apply(artistRequest);
        artistRepository.save(artistMapper.apply(artistRequest));
        return artist;
    }

    public Artist editArtist(Long id, ArtistRequest artistRequest){
        Artist artistActualizado = null;
        for(Artist artist: artistRepository.findAll()){
            if(artist.getIdArtist().equals(id)){
                artistActualizado = artist;
            }
        }

        if(artistRequest.getName() != null){artistActualizado.setNameArtist(artistRequest.getName());}
        if(artistRequest.getGenre() != null){artistActualizado.setGenre(artistRequest.getGenre());}
        if(artistRequest.getImage() != null){artistActualizado.setImage(artistRequest.getImage());}

        artistRepository.save(artistActualizado);
        return artistActualizado;
    }

    public Artist deleteArtist(Long id){
        albumService.setArtistNull(id);
        artistRepository.deleteById(id);
        return null;
    }


    public Boolean guardarArtist(Artist artist){
        artistRepository.save(artist);
        return true;
    }
}
