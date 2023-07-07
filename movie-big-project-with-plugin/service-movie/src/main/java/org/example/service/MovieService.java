package org.example.service;

import org.example.dto.Movie;
import java.util.List;

public interface MovieService {
    Movie add(Movie movie);
    List<Movie> getAll();
}