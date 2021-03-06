package com.cloud.simpleusermanagement.adapter.persistence.eventstore;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.Instant;

@Entity(name = "event_descriptors")
class EventDescriptor {

    @Id
    @GeneratedValue(generator = "event_descriptors_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "event_descriptors_seq", sequenceName = "event_descriptors_seq", allocationSize = 1)
    @Getter
    private Long id;

    @Getter
    @Column(nullable = false, length = 600)
    private String body;

    @Getter
    @Column(nullable = false, name = "occurred_at")
    private Instant occurredAt = Instant.now();

    @Getter
    @Column(nullable = false, length = 60)
    private String type;

    EventDescriptor(String body, Instant occurredAt, String type) {
        this.body = body;
        this.occurredAt = occurredAt;
        this.type = type;
    }

    private EventDescriptor() {
    }
}
