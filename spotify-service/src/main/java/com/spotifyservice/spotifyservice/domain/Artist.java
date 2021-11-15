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
@Table(name = "artist")
public class Artist {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artist_id")
    private Long idArtist;
    @Column(name = "artist_name")
    private String nameArtist;
    @Column(name = "artist_genre")
    private String genre;
    @Column(name = "artist_image")
    private String image;

}
