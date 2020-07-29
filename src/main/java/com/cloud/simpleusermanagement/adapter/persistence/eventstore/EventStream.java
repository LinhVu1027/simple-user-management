package com.cloud.simpleusermanagement.adapter.persistence.eventstore;

import lombok.Getter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static javax.persistence.FetchType.EAGER;

@Entity(name = "event_streams")
class EventStream {

    @Id
    @GeneratedValue(generator = "event_stream_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "event_stream_seq", sequenceName = "event_stream_seq", allocationSize = 1)
    private Long id;

    @Getter
    @Column(unique = true, nullable = false, name = "aggregate_uuid", length = 36)
    private UUID aggregateUUID;

    @Version
    @Column(nullable = false)
    private long version;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = EAGER)
    private List<EventDescriptor> events = new ArrayList<>();

    private EventStream() {
    }

    public EventStream(UUID aggregateUUID) {
        this.aggregateUUID = aggregateUUID;
    }

    void addEvents(List<EventDescriptor> events) {
        this.events.addAll(events);
    }

    List<EventDescriptor> getEvents() {
        return events.stream()
                .sorted(Comparator.comparing(EventDescriptor::getOccurredAt))
                .collect(Collectors.toList());
    }
}
