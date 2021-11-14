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
@Table(name = "ALBUM")
public class Album {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ALBUM")
    private Long idAlbum;

    @OneToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "ID_ARTIST")
    private Artist idArtist;

    @Column(name = "NAME_ALBUM")
    private String nameAlbum;
}
