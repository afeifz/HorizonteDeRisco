package br.com.global.service;

import br.com.global.client.EonetClient;
import br.com.global.dto.nasa.NasaEventReponseDTO;
import org.springframework.stereotype.Service;

@Service
public class NasaEventService {

    private final EonetClient client;

    public NasaEventService(EonetClient client) {
        this.client = client;
    }

    public NasaEventReponseDTO fetchEvents() {
        return client.getEvents();
    }
}