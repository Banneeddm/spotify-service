package com.spotifyservice.spotifyservice.service.implementacion;

import com.spotifyservice.spotifyservice.controller.request.TrackRequest;
import com.spotifyservice.spotifyservice.domain.Track;
import com.spotifyservice.spotifyservice.domain.mapper.TrackMapper;
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
    private IArtistService artistService;

    @Autowired
    private TrackRepository trackRepository;


    public Track getTrack(Long id){
        return trackRepository.findByIdTrack(id);
    }

    public Iterable<Track> getTracks(){
        return trackRepository.findAll();
    }

    public Track createTrack(TrackRequest trackRequest){
        Track track = trackMapper.apply(trackRequest);
        trackRepository.save(trackMapper.apply(trackRequest));
        return track;
    }

    public Track editTrack(Long id, TrackRequest trackRequest){
        Track trackActualizado = null;

        for(Track track: trackRepository.findAll()){
            if(track.getIdTrack().equals(id)){
                trackActualizado = track;
            }
        }

        if(trackRequest.getName() != null){trackActualizado.setNameTrack(trackRequest.getName());}
        if(trackRequest.getDuration() != null){trackActualizado.setDuration(trackRequest.getDuration());}
        if(trackRequest.getReproduction() != null){trackActualizado.setReproduction(trackRequest.getReproduction());}
        if(trackRequest.getIdAlbum() != null){trackActualizado.setIdAlbum(trackRequest.getIdAlbum());}
        if(trackRequest.getIdArtist() != null){trackActualizado.setIdArtist(trackRequest.getIdArtist());}


        trackRepository.save(trackActualizado);
        return trackActualizado;
    }

    public Track deleteTrack(Long id){
        trackRepository.deleteById(id);
        return null;
    }
}
