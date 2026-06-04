package br.com.global.service;


import br.com.global.entity.Alert;
import br.com.global.repository.AlertRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertService {

    private final AlertRepository repository;

    public AlertService(AlertRepository repository) {
        this.repository = repository;
    }

    public List<Alert> findAll() {
        return repository.findAll();
    }
}