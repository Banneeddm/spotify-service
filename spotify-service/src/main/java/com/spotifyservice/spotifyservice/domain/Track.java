package com.spotifyservice.spotifyservice.domain;

import lombok.Data;

@Data
public class Track {

    private int id;
    private String name;
    private int idArtist;
    private int idAlbum;
    private int reproduction;
    private int duration;
}
