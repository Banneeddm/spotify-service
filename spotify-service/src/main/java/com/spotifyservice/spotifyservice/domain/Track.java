package com.spotifyservice.spotifyservice.domain;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "track")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "track_id")
    private Long idTrack;

    @Column(name = "track_name")
    private String nameTrack;

    @OneToOne(cascade = { CascadeType.ALL})
    @JoinColumn(name = "artist_id")
    private Artist idArtist;

    @OneToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "album_id")
    private Album idAlbum;

    @Column(name = "track_reproduction")
    private Long reproduction;

    @Column(name = "track_duration")
    private Double duration;
}
