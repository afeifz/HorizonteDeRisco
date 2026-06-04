package br.com.global.dto.nasa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)

public record CategoryDTO(String id,
                          String title) {
}
