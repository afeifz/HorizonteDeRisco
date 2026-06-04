package br.com.global.service;


import br.com.global.service.risk.FloodRiskAnalyzer;
import br.com.global.service.risk.RiskAnalyzer;
import br.com.global.service.risk.StormRiskAnalyzer;
import br.com.global.service.risk.WildfireRiskAnalyzer;
import org.springframework.stereotype.Service;

@Service
public class RiskClassificationService {

    public String classify(String category) {

        RiskAnalyzer analyzer;

        switch (category.toLowerCase()) {

            case "wildfires":
                analyzer = new WildfireRiskAnalyzer();
                break;

            case "floods":
                analyzer = new FloodRiskAnalyzer();
                break;

            case "severe storms":
                analyzer = new StormRiskAnalyzer();
                break;

            default:
                return "LOW";
        }

        return analyzer.calculateRisk();
    }
}