package org.example.dto;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
    static Validator validator;

    @BeforeAll
    static void initValidator(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

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

    @Test
    void testTitleNotValid() {
        String title = "";
        short year = 2017;
        var movie = Movie.builder()
                .title(title)
                .year(year)
                .build();
        var constraintViolations = validator.validate(movie);
        assertEquals(1, constraintViolations.size(), "title not blank");
    }

    @Test
    void testYearNotValid() {

    }
}