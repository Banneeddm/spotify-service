package com.spotifyservice.spotifyservice.service.implementacion;

import com.spotifyservice.spotifyservice.configuration.exceptions.CustomException;
import com.spotifyservice.spotifyservice.controller.request.ArtistRequest;
import com.spotifyservice.spotifyservice.controller.response.ArtistResponse;
import com.spotifyservice.spotifyservice.domain.Artist;
import com.spotifyservice.spotifyservice.domain.Track;
import com.spotifyservice.spotifyservice.domain.mapper.ArtistMapper;
import com.spotifyservice.spotifyservice.domain.mapper.ArtistResponseMapper;
import com.spotifyservice.spotifyservice.repository.ArtistRepository;
import com.spotifyservice.spotifyservice.repository.TrackRepository;
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
    private ArtistResponseMapper artistResponseMapper;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private TrackRepository trackRepository;


    public ArtistResponse getArtist(Long id){
        Artist artist = artistRepository.findByIdArtist(id);
        if(artist == null){
            throw new CustomException("Invalid ID");
        }
        return artistResponseMapper.apply(artist);
    }

    public Iterable<Artist> getArtists(){
        return artistRepository.findAll();
    }

    public ArtistResponse createArtist(ArtistRequest artistRequest){
        if(artistRequest.getName() == null || artistRequest.getGenre() == null || artistRequest.getImage() == null){
            throw new CustomException("Llene los campos correctamente");
        }
        Artist artist = artistMapper.apply(artistRequest);
        artistRepository.save(artistMapper.apply(artistRequest));
        return artistResponseMapper.apply(artist);
    }

    public ArtistResponse editArtist(Long id, ArtistRequest artistRequest){
        Artist artist = artistRepository.findByIdArtist(id);
        if(artist == null){
            throw new CustomException("Invalid ID");
        }
        if(artistRequest.getName() != null){artist.setNameArtist(artistRequest.getName());}
        if(artistRequest.getGenre() != null){artist.setGenre(artistRequest.getGenre());}
        if(artistRequest.getImage() != null){artist.setImage(artistRequest.getImage());}
        artistRepository.save(artist);
        return artistResponseMapper.apply(artist);
    }

    public Boolean deleteArtist(Long id){
        if(artistRepository.findByIdArtist(id) == null){
            throw new CustomException("Invalid ID");
        }
        albumService.setArtistNull(id);
        Track track = trackRepository.traerArtistTrack(id);
        if(track.getIdArtist().getIdArtist().equals(id)){
            track.setIdArtist(null);
        }
        artistRepository.deleteById(id);
        return true;
    }
}
