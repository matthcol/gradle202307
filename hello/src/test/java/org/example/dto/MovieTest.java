package org.example.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    void testConstructorAllArgs() {
        int id = 2;
        String title = "John Wick 2";
        short year = 2017;
        short duration = 122;
        var movie = new Movie(id, title, year, duration);
        assertAll(
                () -> assertEquals(id, movie.getId(), "id"),
                () -> assertEquals(title, movie.getTitle(), "title"),
                () -> assertEquals(year, movie.getYear(), "year"),
                () -> assertEquals(duration, movie.getDuration(), "duration")
        );
    }

    @Test
    void testBuilder(){
        int id = 2;
        String title = "John Wick 2";
        short year = 2017;
        short duration = 122;
        var movie = Movie.builder()
                .id(id)
                .title(title)
                .year(year)
                .duration(duration)
                .build();
        assertAll(
                () -> assertEquals(id, movie.getId(), "id"),
                () -> assertEquals(title, movie.getTitle(), "title"),
                () -> assertEquals(year, movie.getYear(), "year"),
                () -> assertEquals(duration, movie.getDuration(), "duration")
        );
    }
}