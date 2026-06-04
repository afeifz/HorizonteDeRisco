package br.com.global.service.risk;

import org.springframework.stereotype.Component;

@Component
public class WildfireRiskAnalyzer implements RiskAnalyzer {

    @Override
    public String calculateRisk() {
        return "CRITICAL";
    }
}
