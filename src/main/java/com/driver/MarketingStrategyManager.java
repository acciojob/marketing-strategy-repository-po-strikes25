package com.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MarketingStrategyManager {
    private List<MarketingStrategy> strategies;

    public MarketingStrategyManager() {
        this.strategies = new ArrayList<>();
    }

    public void createStrategy(MarketingStrategy strategy) {
        MarketingStrategy marketingStrategy = new MarketingStrategy(strategy.getName(), strategy.getDescription(), strategy.getTargetAudience(), strategy.getBudget(), strategy.getPotentialROI());
        strategies.add(marketingStrategy);
    }

    public MarketingStrategy getStrategyByName(String name) {
        return strategies.stream()
                .filter(strategy -> strategy.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void updateStrategy(MarketingStrategy updatedStrategy) {
        MarketingStrategy existingStrategy = getStrategyByName(updatedStrategy.getName());
        existingStrategy.setBudget(updatedStrategy.getBudget());
        existingStrategy.setDescription(updatedStrategy.getDescription());
        existingStrategy.setTargetAudience(updatedStrategy.getTargetAudience());
        existingStrategy.setPotentialROI(updatedStrategy.getPotentialROI());
    }

    public void deleteStrategy(String name) {
        MarketingStrategy existingStrategy = getStrategyByName(name);
        strategies.remove(existingStrategy);
    }

    public List<MarketingStrategy> getStrategiesInBudgetRange(double minBudget, double maxBudget) {
        return strategies.stream()
                .filter(strategy -> strategy.getBudget() >= minBudget && strategy.getBudget() <= maxBudget)
                .collect(Collectors.toList());
    }

    public List<MarketingStrategy> getAllStrategies() {
        return new ArrayList<>(strategies);
    }
}

