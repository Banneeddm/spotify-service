package com.spotifyservice.spotifyservice.service;

import com.spotifyservice.spotifyservice.controller.request.TrackRequest;
import com.spotifyservice.spotifyservice.domain.Track;
import com.spotifyservice.spotifyservice.domain.TrackMapper;
import com.spotifyservice.spotifyservice.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TrackService {

    List<Track> listaTrack = new ArrayList<>();

    @Autowired
    private TrackMapper trackMapper;

    @Autowired
    private TrackRepository trackRepository;

    public void initTrack(){
        if (listaTrack.isEmpty()) {
            TrackRequest track = new TrackRequest();
            track.setIdAlbum(1L);
            track.setIdArtist(1L);
            track.setName("Track1");
            track.setReproduction(123L);
            track.setDuration(5.32);

            createTrack(track);

            listaTrack.stream().forEach(track1 -> {
                trackRepository.save(track1);
            });
        }
    }

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

    /**
    public List<Track> getTrack(Long id) {
        return listaTrack.stream().filter(x -> Objects.equals(x.getId(),id)).collect(Collectors.toList());
    }

    public List<Track> getTracks() {
        return listaTrack;
    }

    public List<Track> createTrack(TrackRequest trackRequest){
        listaTrack.add(trackMapper.apply(trackRequest));
        return listaTrack;
    }

    public List<Track> editTrack(Long id, TrackRequest trackRequest){
        Track trackActualizado = null;
        int aux = 0;
        int pos = 0;

        for(Track track: listaTrack){
            if(track.getId().equals(id)){
                trackActualizado = track;
                aux = pos;
            }
            pos ++;
        }

        trackActualizado.setNameTrack(trackRequest.getName());

        listaTrack.remove(aux);
        listaTrack.add(aux,trackActualizado);

        return listaTrack;
    }

    public List<Track> deleteTrack(Long id){
        listaTrack.removeIf(track -> track.getId().equals(id));
        return listaTrack;
    }
     **/
}
