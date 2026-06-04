package br.com.global.dto.nasa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SourceDTO(

        String id,

        String url

) {
}
