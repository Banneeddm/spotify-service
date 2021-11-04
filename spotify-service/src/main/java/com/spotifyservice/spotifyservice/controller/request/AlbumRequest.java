package com.spotifyservice.spotifyservice.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AlbumRequest {

    private Long idAlbum;
    private Long idArtist;
    private String name;

}
