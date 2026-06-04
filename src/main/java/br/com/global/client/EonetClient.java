package br.com.global.client;

import br.com.global.dto.nasa.NasaEventReponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.ObjectMapper;

@Component
public class EonetClient {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Value("${nasa.eonet.url}")
    private String url;

    public EonetClient(
            RestTemplate restTemplate,
            ObjectMapper objectMapper
    ) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public NasaEventReponseDTO getEvents() {

        try {

            String json =
                    restTemplate.getForObject(
                            url,
                            String.class
                    );

            return objectMapper.readValue(
                    json,
                    NasaEventReponseDTO.class
            );

        } catch (Exception e) {

            System.out.println("URL: " + url);

            e.printStackTrace();

            throw new RuntimeException(e);
        }
    }
}

//testing