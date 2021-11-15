package com.spotifyservice.spotifyservice.service;

import com.spotifyservice.spotifyservice.controller.request.TrackRequest;
import com.spotifyservice.spotifyservice.domain.Album;
import com.spotifyservice.spotifyservice.domain.Artist;
import com.spotifyservice.spotifyservice.domain.Track;
import com.spotifyservice.spotifyservice.domain.TrackMapper;
import com.spotifyservice.spotifyservice.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
        trackNew = track;
        if(trackRequest.getIdArtist() != null){
            for(Artist artist: artistService.getArtists()) {
                if (artist.getIdArtist().equals(trackRequest.getIdArtist().getIdArtist())) {
                    trackNew.setIdArtist(artist);
                }
            }
        } else{
            trackNew.setIdArtist(null);
        }
        if(trackRequest.getIdAlbum() != null){
            for(Album album: albumService.getAlbums()) {
                if (album.getIdAlbum().equals(trackRequest.getIdAlbum().getIdAlbum())) {
                    trackNew.setIdAlbum(album);
                }
            }
        }else{
            trackNew.setIdAlbum(null);
        }
        trackRepository.save(trackNew);
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
        if(trackRequest.getIdArtist() != null) {
            for(Artist artist: artistService.getArtists()){
                if(artist.getIdArtist().equals(trackRequest.getIdArtist().getIdArtist())){
                    trackActualizado.setIdArtist(artist);
                }
            }
        }
        if(trackRequest.getIdAlbum() != null){
            for(Album album: albumService.getAlbums()){
                if(album.getIdAlbum().equals(trackRequest.getIdAlbum().getIdAlbum())){
                    trackActualizado.setIdAlbum(album);
                }
            }
        }
        trackRepository.save(trackActualizado);
        return trackActualizado;
    }

    public Track deleteTrack(Long id){
        Album album = null;
        Artist artist = null;

        for(Track track: trackRepository.findAll()){
            if(track.getIdArtist().getIdArtist().equals(trackRepository.findByIdTrack(id).getIdArtist().getIdArtist())
            || track.getIdAlbum().getIdAlbum().equals(trackRepository.findByIdTrack(id).getIdAlbum().getIdAlbum())) {
                album = trackRepository.findByIdTrack(id).getIdAlbum();
                artist = trackRepository.findByIdTrack(id).getIdArtist();
            }
            trackRepository.deleteById(id);
            if(album.getIdArtist().getIdArtist() != artist.getIdArtist()){
                artistService.guardarArtist(artist);
            }
            albumService.guardarAlbum(album);
        }
        return null;
    }

    public void actualizarEstadoAlbum(Long idAlbum){
        for(Track track: trackRepository.findAll()){
            if(track.getIdAlbum().getIdAlbum().equals(idAlbum) && track.getIdAlbum() != null){
                track.setIdAlbum(null);
            }
        }
    }

    public void actualizarEstadoArtist(Long idArtist){
        for(Track track: trackRepository.findAll()){
            if(track.getIdArtist().getIdArtist().equals(idArtist) && track.getIdTrack() != null){
                track.setIdArtist(null);
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

    public List<Track> rank() {
        ArrayList rank = new ArrayList<>();
        List<Track> top5 = new ArrayList<Track>();
        for(Track track: trackRepository.findAll()){
            rank.add(track);
        }
        Collections.sort(rank, new Comparator<Track>() {
            public int compare(Track t1, Track t2){
                return (t2.getReproduction().compareTo(t1.getReproduction()));
            }
        });
        for(int i = 0; i < 5; i++){
            top5.add((Track) rank.get(i));
        }
        return top5;
    }
}
