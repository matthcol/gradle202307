package org.example;

import org.example.service.MovieService;
import org.example.service.impl.MovieServiceDummy;

public class Main {
    public static void main(String[] args) {
        MovieService movieService = new MovieServiceDummy();
        System.out.println("Api running for a few seconds");
        System.out.println("movies: " + movieService.getAll());
    }
}