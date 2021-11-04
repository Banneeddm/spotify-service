package com.spotifyservice.spotifyservice.configuration;

import com.spotifyservice.spotifyservice.domain.Track;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class TrackConfiguration {

    Track track1 = new Track(1L, "name1", 1L, 1L, 0L, 6.2);
    Track track2 = new Track(2L, "name2", 2L, 2L, 0L, 3.15);
    Track track3 = new Track(3L, "name3", 3L, 3L, 0L, 4.17);
    Track track4 = new Track(4L, "name4", 4L, 4L, 0L, 2.34);
    Track track5 = new Track(5L, "name5", 5L, 5L, 0L, 5.32);

    @Bean(name = "/{idTrack}")
    public Track getTrack(){
        return track1;
    }

    @Bean(name = "tracks")
    public List<Track> getTracks(){
        return Arrays.asList(track1,track2,track3,track4,track5);
    }
}
