package com.spotifyservice.spotifyservice.service;

import com.spotifyservice.spotifyservice.controller.request.ArtistRequest;
import com.spotifyservice.spotifyservice.domain.Artist;
import com.spotifyservice.spotifyservice.domain.ArtistMapper;
import com.spotifyservice.spotifyservice.domain.Track;
import com.spotifyservice.spotifyservice.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistService {

    List<Artist> listaArtist = new ArrayList<Artist>();

    @Autowired
    private TrackService trackService;

    @Autowired
    private ArtistMapper artistMapper;

    @Autowired
    private ArtistRepository artistRepository;


    public void initArtist(){
        if (listaArtist.isEmpty()) {
            ArtistRequest artis1 = new ArtistRequest();
            artis1.setName("Artista 1");
            artis1.setGenre("Genre 1");
            artis1.setImage("Image 1");

            createArtist(artis1);

            listaArtist.stream().forEach(artist -> {
                artistRepository.save(artist);
            });
        }
    }

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
        artistRepository.deleteById(id);
        return null;
    }

    /**
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

    public List<Artist> editArtist(Long id, ArtistRequest artistRequest){
        Artist artistActualizado = null;
        int aux = 0;
        int pos = 0;

        for(Artist artist: listaArtist){
            if(artist.getIdArtist().equals(id)){
                artistActualizado = artist;
                aux = pos;
            }
            pos ++;
        }

        artistActualizado.setGenre(artistRequest.getGenre());
        artistActualizado.setName(artistRequest.getName());
        artistActualizado.setImage(artistRequest.getImage());

        listaArtist.remove(aux);
        listaArtist.add(aux, artistActualizado);

        return listaArtist;
    }

    public List<Artist> deleteArtist(Long id){
        listaArtist.removeIf(artist -> artist.getIdArtist().equals(id));
        return listaArtist;
    }

    public List<Track> getTracks(){
        return trackService.getTracks();
    }**/
}
