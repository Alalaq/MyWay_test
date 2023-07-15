package com.example.test;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

@Route("main")
@UIScope
public class MainView extends VerticalLayout {
    private final CounterService counterService;

    @Autowired
    public MainView(CounterService counterService) {
        this.counterService = counterService;

        TextField counterField = new TextField("Counter");
        counterField.setValue(String.valueOf(counterService.getCounter().getValue()));

        Button incrementButton = new Button("Increment", event -> {
            counterService.incrementCounter();
            counterField.setValue(String.valueOf(counterService.getCounter().getValue()));
        });

        add(counterField, incrementButton);
    }
}