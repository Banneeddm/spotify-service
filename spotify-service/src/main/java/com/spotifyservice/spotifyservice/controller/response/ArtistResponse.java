package com.spotifyservice.spotifyservice.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ArtistResponse {

    private Long id;
    private String name;
    private String genre;
    private String image;
}
