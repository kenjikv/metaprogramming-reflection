package com.metaprogramming.metaprogramming;

import com.metaprogramming.metaprogramming.service.PerformanceTestService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PerformanceTestRunner implements CommandLineRunner {
    private final PerformanceTestService performanceTestService;

    public PerformanceTestRunner(PerformanceTestService performanceTestService) {
        this.performanceTestService = performanceTestService;
    }

    @Override
    public void run(String... args) {
        System.out.println("Ejecutando prueba de rendimiento...");
        performanceTestService.runPerformanceTest();
    }
}