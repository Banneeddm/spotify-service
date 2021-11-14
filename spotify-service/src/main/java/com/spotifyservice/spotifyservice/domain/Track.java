package com.spotifyservice.spotifyservice.domain;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "TRACK")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TRACK")
    private Long idTrack;

    @Column(name = "NAME_TRACK")
    private String nameTrack;

    @Column(name = "ID_ARTIST")
    private Long idArtist;

    @OneToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "ID_ALBUM")
    private Album idAlbum;

    @Column(name = "REPRODUCTION")
    private Long reproduction;

    @Column(name = "DURATION")
    private Double duration;
}
