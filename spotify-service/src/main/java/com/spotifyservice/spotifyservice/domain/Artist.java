package com.spotifyservice.spotifyservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Artist {

    private Long idArtist;
    private String name;
    private String genre;
    private String image;

    public Long getid(){
        return idArtist;
    }
}
