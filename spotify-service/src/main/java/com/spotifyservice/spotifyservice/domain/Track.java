package com.spotifyservice.spotifyservice.domain;

import lombok.*;

import javax.persistence.*;

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
