package com.spotifyservice.spotifyservice.service;

import com.spotifyservice.spotifyservice.controller.request.ArtistRequest;
import com.spotifyservice.spotifyservice.domain.Artist;
import com.spotifyservice.spotifyservice.domain.ArtistMapper;
import com.spotifyservice.spotifyservice.domain.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ArtistService {

    List<Artist> listaArtist = new ArrayList<Artist>();

    @Autowired
    private TrackService trackService;

    @Autowired
    private ArtistMapper artistMapper;

    public void initArtist(){
        if (listaArtist.isEmpty()) {
            ArtistRequest artis1 = new ArtistRequest();
            artis1.setIdArtist(1L);
            artis1.setName("Artista 1");
            artis1.setGenre("Genre 1");
            artis1.setImage("Image 1");

            createArtist(artis1);
        }
    }


    public Artist artistInit(){
        for(Artist artist: listaArtist){
            return artist;
        }
        return null;
    }

    public List<Artist> getArtist(Long id){
        return listaArtist.stream().filter(x -> Objects.equals(x.getIdArtist(), id)).collect(Collectors.toList());
    }
    public List<Artist> getArtists(){
        return listaArtist;
    }
    public List<Artist> createArtist(ArtistRequest artistRequest){
        listaArtist.add(artistMapper.apply(artistRequest));
        return listaArtist;
    }

    public List<Track> getTracks(){
        return trackService.getTracks();
    }

}
