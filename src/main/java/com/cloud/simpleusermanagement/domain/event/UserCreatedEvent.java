package com.cloud.simpleusermanagement.domain.event;

import com.cloud.simpleusermanagement.domain.UserState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreatedEvent implements DomainEvent {

    public static final String TYPE = "user.created";

    private UUID uuid;

    private UserState state;
    private String name;
    private String email;
    private String individualUii;
    private String contactNumber;

    private Instant occurredAt;

    @Override
    public String type() {
        return TYPE;
    }

    @Override
    public Instant getOccurredAt() {
        return this.occurredAt;
    }

    @Override
    public UUID uuid() {
        return this.uuid;
    }
}
