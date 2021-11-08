package com.spotifyservice.spotifyservice.service;

import com.spotifyservice.spotifyservice.controller.request.TrackRequest;
import com.spotifyservice.spotifyservice.domain.Track;
import com.spotifyservice.spotifyservice.domain.TrackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    public void initTrack(){
        if (listaTrack.isEmpty()) {
            TrackRequest track = new TrackRequest();
            track.setId(1L);
            track.setIdAlbum(1L);
            track.setIdArtist(1L);
            track.setName("Track1");
            track.setReproduction(123L);
            track.setDuration(5.32);

            createTrack(track);
        }
    }

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

        trackActualizado.setName(trackRequest.getName());

        listaTrack.remove(aux);
        listaTrack.add(aux,trackActualizado);

        return listaTrack;
    }

    public List<Track> deleteTrack(Long id){
        listaTrack.removeIf(track -> track.getId().equals(id));
        return listaTrack;
    }
}
