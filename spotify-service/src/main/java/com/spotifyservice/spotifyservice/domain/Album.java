package com.spotifyservice.spotifyservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "album")
public class Album {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id")
    private Long idAlbum;

    @OneToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "artist_id")
    private Artist idArtist;

    @Column(name = "album_name")
    private String nameAlbum;
}
