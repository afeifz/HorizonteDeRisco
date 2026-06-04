package br.com.global.controller;


import br.com.global.entity.Alert;
import br.com.global.repository.AlertRepository;
import br.com.global.service.AlertService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class AlertController {

    private final AlertService service;
    private final AlertRepository alertRepository;

    public AlertController(AlertService service, AlertRepository alertRepository) {
        this.service = service;
        this.alertRepository = alertRepository;
    }

    @GetMapping
    public List<Alert> getAll() {
        return service.findAll();
    }

    @GetMapping("/alerts/{risk}")
    public List<Alert> getAlertsByRisk(
            @PathVariable String risk
    ) {
        return alertRepository.findByRiskLevel(risk);
    }
}