package br.com.global.controller;

import br.com.global.dto.nasa.NasaEventReponseDTO;
import br.com.global.entity.Alert;
import br.com.global.repository.AlertRepository;
import br.com.global.service.NasaEventService;
import br.com.global.service.SyncService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final SyncService syncService;
    private final NasaEventService nasaEventService;
    private final AlertRepository alertRepository;

    public EventController(
            SyncService syncService,
            NasaEventService nasaEventService,
            AlertRepository alertRepository
    ) {
        this.syncService = syncService;
        this.nasaEventService = nasaEventService;
        this.alertRepository = alertRepository;
    }

    @GetMapping
    public NasaEventReponseDTO getEvents() {
        return nasaEventService.fetchEvents();
    }

    @PostMapping("/sync")
    public String sync() {

        int total = syncService.syncEvents();

        return total + " eventos importados.";
    }

    @GetMapping("/alerts")
    public List<Alert> getAlerts() {
        return alertRepository.findAll();
    }

    @GetMapping("/alerts/{risk}")
    public List<Alert> getAlertsByRisk(
            @PathVariable String risk
    ) {
        return alertRepository.findByRiskLevel(risk);
    }
}