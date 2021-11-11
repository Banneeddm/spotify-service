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
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlbum;
    private Long idArtist;
    private String nameAlbum;
}
