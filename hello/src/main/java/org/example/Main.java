package org.example;

import org.example.dto.Movie;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        var movie = Movie.builder().title("The Covenant").year((short) 2023).build();
        System.out.println("Let's watch:" + movie);
    }
}