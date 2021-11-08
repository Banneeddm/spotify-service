package com.spotifyservice.spotifyservice.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ArtistRequest {


    private Long idArtist;
    private String name;
    private String genre;
    private String image;
}
