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
    private Artist idArtist;
    private Album idAlbum;
    private Long reproduction;
    private Double duration;
}
