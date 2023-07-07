package org.example.service.impl;

import org.example.dto.Movie;
import org.example.service.MovieService;

import java.util.List;

public class MovieServiceDummy implements MovieService {
    @Override
    public Movie add(Movie movie) {
        return new Movie();
    }

    @Override
    public List<Movie> getAll() {
        return List.of();
    }
}
