package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CounterService {
    private final CounterRepository counterRepository;

    @Autowired
    public CounterService(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    public Counter getCounter() {
        return counterRepository.findById(1L).orElse(new Counter());
    }

    public void incrementCounter() {
        Counter counter = getCounter();
        counter.setValue(counter.getValue() + 1);
        counterRepository.save(counter);
    }
}
