package br.com.global.repository;

import br.com.global.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertRepository
        extends JpaRepository<Alert, Long>
{
    List<Alert> findByRiskLevel(String riskLevel);
}