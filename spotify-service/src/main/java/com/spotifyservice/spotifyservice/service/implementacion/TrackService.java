package com.spotifyservice.spotifyservice.service.implementacion;

import com.spotifyservice.spotifyservice.configuration.exeptions.CustomException;
import com.spotifyservice.spotifyservice.controller.request.TrackRequest;
import com.spotifyservice.spotifyservice.controller.response.TrackResponse;
import com.spotifyservice.spotifyservice.domain.Album;
import com.spotifyservice.spotifyservice.domain.Artist;
import com.spotifyservice.spotifyservice.domain.Track;
import com.spotifyservice.spotifyservice.domain.mapper.TrackMapper;
import com.spotifyservice.spotifyservice.domain.mapper.TrackResponseMapper;
import com.spotifyservice.spotifyservice.repository.AlbumRepository;
import com.spotifyservice.spotifyservice.repository.ArtistRepository;
import com.spotifyservice.spotifyservice.repository.TrackRepository;
import com.spotifyservice.spotifyservice.service.IArtistService;
import com.spotifyservice.spotifyservice.service.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrackService implements ITrackService {

    List<Track> listaTrack = new ArrayList<>();

    @Autowired
    private TrackMapper trackMapper;

    @Autowired
    private TrackResponseMapper trackResponseMapper;

    @Autowired
    private IArtistService artistService;

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private AlbumRepository albumRepository;

    public TrackResponse getTrack(Long id){
        Track track = trackRepository.findByIdTrack(id);
        if(track == null){
            throw new CustomException("Invalid Id");
        }
        return trackResponseMapper.apply(track);
    }

    public Iterable<Track> getTracks(){
        return trackRepository.findAll();
    }

    public TrackResponse createTrack(TrackRequest trackRequest){
        if(trackRequest.getName() == null || trackRequest.getReproduction() == null || trackRequest.getDuration() == null){
            throw new CustomException("Llene correctamente todos los campos");
        }
        Track track = trackMapper.apply(trackRequest);
        Artist artist = artistRepository.findByIdArtist(track.getIdArtist().getIdArtist());
        if(artist == null){
            throw new CustomException("Invalid ID Artist");
        }
        track.setIdArtist(artist);
        Album album = albumRepository.findByIdAlbum(track.getIdAlbum().getIdAlbum());
        if(album == null){
            throw new CustomException("Invalid ID Album");
        }
        track.setIdAlbum(album);
        trackRepository.save(track);
        return trackResponseMapper.apply(track);
    }

    public TrackResponse editTrack(Long id, TrackRequest trackRequest){
        Track track = trackRepository.findByIdTrack(id);
        if(track == null){
            throw new CustomException("Invalid ID Track");
        }
        if(trackRequest.getName() != null){track.setNameTrack(trackRequest.getName());}
        if(trackRequest.getDuration() != null){track.setDuration(trackRequest.getDuration());}
        if(trackRequest.getReproduction() != null){track.setReproduction(trackRequest.getReproduction());}
        if(trackRequest.getIdArtist() != null){
            Artist artist = artistRepository.findByIdArtist(trackRequest.getIdArtist().getIdArtist());
            if(artist == null){
                throw new CustomException("Invalid ID Artist");
            }
            track.setIdArtist(artist);
        }
        if(trackRequest.getIdAlbum() != null){
            Album album = albumRepository.findByIdAlbum(trackRequest.getIdAlbum().getIdAlbum());
            if(album == null){
                throw new CustomException("Invalid ID Album");
            }
            track.setIdAlbum(album);
        }
        trackRepository.save(track);
        return trackResponseMapper.apply(track);
    }

    public Track deleteTrack(Long id){
        trackRepository.deleteById(id);
        return null;
    }
}
