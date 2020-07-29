package com.cloud.simpleusermanagement.application.port.out;

import com.cloud.simpleusermanagement.domain.event.DomainEvent;

public interface SendUserEventToBroker {
    void send(DomainEvent event);
}
