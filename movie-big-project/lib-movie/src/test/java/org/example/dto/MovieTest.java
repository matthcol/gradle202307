package org.example.dto;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " ", "\t", "\r", "\n", "\f", " \t \r\n"})
    void testTitleNotValid(String title) {
        short year = 2017;
        var movie = Movie.builder()
                .title(title)
                .year(year)
                .build();
        var constraintViolations = validator.validate(movie);
        assertEquals(1, constraintViolations.size(), "title not blank");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1887})
    void testYearNotValid(int intYear) {
        String title = "John Wick 2";
        short year = (short) intYear;
        var movie = Movie.builder()
                .title(title)
                .year(year)
                .build();
        var constraintViolations = validator.validate(movie);
        assertEquals(1, constraintViolations.size(), "yeat min 1888");
    }

    @Test
    void featureJava11(){
        var titles = List.of("John Wick 4", "The Whale");
        var titleSet = Set.of("John Wick 4", "The Whale");
        var indexTitleYear = Map.of(
                "John Wick 2", 2017,
                "John Wick 4", 2023,
                "The Whale", 2023
        );
    }
}