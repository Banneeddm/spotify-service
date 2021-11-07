package com.spotifyservice.spotifyservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Track {

    private Long id;
    private String name;
    private Long idArtist;
    private Long idAlbum;
    private Long reproduction;
    private Double duration;
}
