package com.spotifyservice.spotifyservice.controller.request;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TrackRequest {

    private Long id;
    private String name;
    private Long idArtist;
    private Long idAlbum;
    private Long reproduction;
    private Double duration;

}
