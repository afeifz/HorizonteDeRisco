package br.com.global.controller;

import br.com.global.dto.nasa.NasaEventReponseDTO;
import br.com.global.entity.Alert;
import br.com.global.entity.NaturalEvent;
import br.com.global.repository.AlertRepository;
import br.com.global.repository.EventRepository;
import br.com.global.service.NasaEventService;
import br.com.global.service.SyncService;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final SyncService syncService;
    private final NasaEventService nasaEventService;
    private final AlertRepository alertRepository;
    private final EventRepository eventRepository;
    private static final Logger log =
            LoggerFactory.getLogger(
                    EventController.class
            );

    public EventController(
            SyncService syncService,
            NasaEventService nasaEventService,
            AlertRepository alertRepository,
            EventRepository eventRepository) {
        this.syncService = syncService;
        this.nasaEventService = nasaEventService;
        this.alertRepository = alertRepository;
        this.eventRepository = eventRepository;
    }

    @GetMapping
    public NasaEventReponseDTO getEvents() {

        log.info(
                "Consulta de eventos NASA realizada"
        );
        return nasaEventService.fetchEvents();
    }

    @PostMapping("/sync")
    public String sync() {

        log.info(
                "Sincronização iniciada"
        );

        int total = syncService.syncEvents();

        log.info(
                "Sincronização concluída. Total: {}",
                total
        );


        return total + " eventos importados.";
    }

    @GetMapping("/alerts")
    public List<Alert> getAlerts() {
        log.info(
                "Consulta de alertas realizada"
        );
        return alertRepository.findAll();
    }

    @GetMapping("/alerts/{risk}")
    public List<Alert> getAlertsByRisk(
            @PathVariable String risk
    ) {
        return alertRepository.findByRiskLevel(risk);
    }

}