package br.com.global.dto.nasa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record NasaEventReponseDTO( String title,
                                   String description,
                                   String link,
                                   List<NasaEventDTO> events) {
}
