package com.spotifyservice.spotifyservice.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TrackResponse {
    private Long id;
    private String name;
    private Long idArtist;
    private String nameArtist;
    private Long idAlbum;
    private String nameAlbum;
    private Long reproduction;
    private Double duration;
}
