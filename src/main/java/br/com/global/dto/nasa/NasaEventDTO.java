package br.com.global.dto.nasa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public record NasaEventDTO( String id,
                            String title,
                            String description,
                            String link,
                            String closed,
                            List<CategoryDTO> categories,
                            List<SourceDTO> sources,
                            List<GeometryDTO> geometry) {
}
