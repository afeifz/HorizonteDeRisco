package br.com.global.dto.nasa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;



@JsonIgnoreProperties(ignoreUnknown = true)

public record GeometryDTO(Double magnitudeValue,
                          String magnitudeUnit,
                          String date,
                          String type,
                          List<Double> coordinates) {
}
