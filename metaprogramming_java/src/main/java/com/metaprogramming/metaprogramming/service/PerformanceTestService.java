package com.metaprogramming.metaprogramming.service;

import org.springframework.stereotype.Service;

import com.metaprogramming.metaprogramming.entity.user.User;
import com.metaprogramming.metaprogramming.repository.GenericRepository;
import com.metaprogramming.metaprogramming.repository.user.UserRepository;

@Service
public class PerformanceTestService {
    private final GenericRepository<User> genericRepository;
    private final UserRepository userRepository;

    public PerformanceTestService(GenericRepository<User> genericRepository, UserRepository userRepository) {
        this.genericRepository = genericRepository;
        this.userRepository = userRepository;
    }

    public void runPerformanceTest() {
        User user = new User(7, "Juan", "Perez", "juan.perez@example.com");

        // Prueba con Reflection
        long startReflection = System.nanoTime();
        long memoryBeforeReflection = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        genericRepository.insert(user);

        long endReflection = System.nanoTime();
        long memoryAfterReflection = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long memoryUsedReflection = memoryAfterReflection - memoryBeforeReflection;
        long timeReflectionNs = endReflection - startReflection;

        // Prueba con inserción manual
        long startManual = System.nanoTime();
        long memoryBeforeManual = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        userRepository.insertUser(8, "Carlos", "Lopez", "carlos.lopez@example.com");

        long endManual = System.nanoTime();
        long memoryAfterManual = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long memoryUsedManual = memoryAfterManual - memoryBeforeManual;
        long timeManualNs = endManual - startManual;

        // Convertir nanosegundos a milisegundos y segundos
        double timeReflectionMs = timeReflectionNs / 1_000_000.0;
        double timeManualMs = timeManualNs / 1_000_000.0;

        double timeReflectionS = timeReflectionMs / 1000.0;
        double timeManualS = timeManualMs / 1000.0;

        // Resultados
        System.out.println("Tiempo con Reflection: " + timeReflectionMs + " ms (" + timeReflectionS + " s)");
        System.out.println("Memoria usada con Reflection: " + memoryUsedReflection + " bytes");

        System.out.println("Tiempo con inserción manual: " + timeManualMs + " ms (" + timeManualS + " s)");
        System.out.println("Memoria usada con inserción manual: " + memoryUsedManual + " bytes");
    }
}
