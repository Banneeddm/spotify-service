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
@Table(name = "ARTIST")
public class Artist {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ARTIST")
    private Long idArtist;
    @Column(name = "NAME_ARTIST")
    private String nameArtist;
    @Column(name = "GENRE")
    private String genre;
    @Column(name = "IMAGE")
    private String image;

}
