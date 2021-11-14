package com.spotifyservice.spotifyservice.service;

import com.spotifyservice.spotifyservice.controller.request.TrackRequest;
import com.spotifyservice.spotifyservice.domain.Album;
import com.spotifyservice.spotifyservice.domain.Track;
import com.spotifyservice.spotifyservice.domain.TrackMapper;
import com.spotifyservice.spotifyservice.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrackService {

    List<Track> listaTrack = new ArrayList<>();

    @Autowired
    private TrackMapper trackMapper;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private ArtistService artistService;

    @Autowired
    private TrackRepository trackRepository;


    public Track getTrack(Long id){
        return trackRepository.findByIdTrack(id);
    }

    public Iterable<Track> getTracks(){
        return trackRepository.findAll();
    }

    public Track createPrimerTrack(TrackRequest trackRequest){
        Track track = trackMapper.apply(trackRequest);
        trackRepository.save(trackMapper.apply(trackRequest));
        return track;
    }

    public Track createTrack(TrackRequest trackRequest){
        Track trackNew = null;
        Track track = trackMapper.apply(trackRequest);
        for(Album album: albumService.getAlbums()){
            if(album.getIdAlbum().equals(trackRequest.getIdAlbum().getIdAlbum())){
                trackNew = track;
                trackNew.setIdAlbum(album);
                trackRepository.save(trackNew);
            }
            else{
                trackNew = track;
                trackNew.setIdAlbum(null);
                trackRepository.save(trackNew);
            }
        }
        return trackNew;
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
        for(Album album: albumService.getAlbums()){
            if(album.getIdAlbum().equals(trackRequest.getIdAlbum().getIdAlbum())){
                trackActualizado.setIdAlbum(album);
            }
        }
        if(trackRequest.getIdArtist() != null){trackActualizado.setIdArtist(trackRequest.getIdArtist());}


        trackRepository.save(trackActualizado);
        return trackActualizado;
    }

    public Track deleteTrack(Long id){
        Album album = null;
        for(Album album1: albumService.getAlbums()){
            if(album1.getIdAlbum().equals(trackRepository.findByIdTrack(id).getIdAlbum().getIdAlbum())){
                album = album1;
                trackRepository.deleteById(id);
                albumService.guardarAlbum(album);
            }
            else {
                trackRepository.deleteById(id);
            }
        }
        if(trackRepository.findByIdTrack(id) != null){
            trackRepository.deleteById(id);
        }
        return null;
    }

    public void setAlbumNull(Long idAlbum){
        for(Track track: trackRepository.findAll()){
            if(track.getIdAlbum().getIdAlbum().equals(idAlbum)){
                track.setIdAlbum(null);
            }
        }
    }

    public void guardarTrack(Track track){
        trackRepository.save(track);
    }


    public Track playTrack(Long id){
        Track playTrack = null;
        for(Track track: trackRepository.findAll()){
            if(track.getIdTrack().equals(id)){
                playTrack = track;
            }
        }
        playTrack.setReproduction(playTrack.getReproduction() + 1);
        trackRepository.save(playTrack);
        return playTrack;
    }
}
