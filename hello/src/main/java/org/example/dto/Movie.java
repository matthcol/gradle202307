package org.example.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

// Exo1: lombok: constructor/builder + getter/setter
// Bean validation: title, year mandatory, title not blank, year >= 1888
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Movie {
    private Integer id;

    @NotBlank
    private String title;

    @Min(1888)
    private short year;
    private Short duration;
}
