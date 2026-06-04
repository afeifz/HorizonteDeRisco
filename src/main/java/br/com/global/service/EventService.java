package br.com.global.service;


import br.com.global.entity.NaturalEvent;
import br.com.global.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    public List<NaturalEvent> findAll() {
        return repository.findAll();
    }

    public NaturalEvent save(NaturalEvent event) {
        return repository.save(event);
    }
}
