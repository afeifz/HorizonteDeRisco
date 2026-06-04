package br.com.global.service;


import br.com.global.client.EonetClient;
import br.com.global.dto.nasa.GeometryDTO;
import br.com.global.dto.nasa.NasaEventDTO;
import br.com.global.dto.nasa.NasaEventReponseDTO;
import br.com.global.entity.Alert;
import br.com.global.entity.NaturalEvent;
import br.com.global.repository.AlertRepository;
import br.com.global.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Service
public class SyncService {

    private final EonetClient client;
    private final EventRepository eventRepository;
    private final AlertRepository alertRepository;
    private final RiskClassificationService riskService;

    public SyncService(
            EonetClient client,
            EventRepository eventRepository,
            AlertRepository alertRepository,
            RiskClassificationService riskService
    ) {
        this.client = client;
        this.eventRepository = eventRepository;
        this.alertRepository = alertRepository;
        this.riskService = riskService;
    }

    public int syncEvents() {

        NasaEventReponseDTO response =
                client.getEvents();
        System.out.println("EVENTOS RECEBIDOS: " + response.events().size());

        int imported = 0;
        int limit = 50;

        for (NasaEventDTO event : response.events()) {
            if (imported >= limit) {
                break;
            }

            System.out.println("EVENTO: " + event.title());


            if (eventRepository.existsByNasaId(event.id())) {
                continue;
            }

            String category =
                    event.categories().get(0).title();

            String risk =
                    riskService.classify(category);

            GeometryDTO geometry =
                    event.geometry().get(0);

            NaturalEvent entity =
                    NaturalEvent.builder()
                            .nasaId(event.id())
                            .title(event.title())
                            .category(category)
                            .eventDate(
                                    OffsetDateTime
                                            .parse(
                                                    geometry.date()
                                            )
                                            .toLocalDateTime()
                            )
                            .longitude(
                                    geometry.coordinates().get(0)
                            )
                            .latitude(
                                    geometry.coordinates().get(1)
                            )
                            .riskLevel(risk)
                            .build();

            eventRepository.save(entity);

            Alert alert =
                    Alert.builder()
                            .message(
                                    "Evento "
                                            + category
                                            + " detectado"
                            )
                            .riskLevel(risk)
                            .createdAt(LocalDateTime.now())
                            .build();

            alertRepository.save(alert);

            imported++;
        }

        return imported;
    }
}

