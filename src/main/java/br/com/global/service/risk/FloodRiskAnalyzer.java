package br.com.global.service.risk;

import org.springframework.stereotype.Component;

@Component
public class FloodRiskAnalyzer implements RiskAnalyzer {

    @Override
    public String calculateRisk() {
        return "HIGH";
    }
}
