package com.spotifyservice.spotifyservice.controller.request;

import com.spotifyservice.spotifyservice.domain.Album;
import com.spotifyservice.spotifyservice.domain.Artist;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TrackRequest {

    private Long id;
    private String name;
    private Artist idArtist;
    private Album idAlbum;
    private Long reproduction;
    private Double duration;

}
