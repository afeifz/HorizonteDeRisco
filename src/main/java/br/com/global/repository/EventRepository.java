package br.com.global.repository;


import br.com.global.entity.NaturalEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository
        extends JpaRepository<NaturalEvent, Long> {

    boolean existsByNasaId(String nasaId);

}