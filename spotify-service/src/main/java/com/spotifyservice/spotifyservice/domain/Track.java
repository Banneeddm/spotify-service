package com.spotifyservice.spotifyservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTrack;
    private String nameTrack;
    private Long idArtist;
    private Long idAlbum;
    private Long reproduction;
    private Double duration;
}
