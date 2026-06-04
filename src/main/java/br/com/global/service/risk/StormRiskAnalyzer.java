package br.com.global.service.risk;

import org.springframework.stereotype.Component;

@Component
public class StormRiskAnalyzer implements RiskAnalyzer {

    @Override
    public String calculateRisk() {
        return "MEDIUM";
    }
}