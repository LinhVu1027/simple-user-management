package com.cloud.simpleusermanagement.adapter.persistence;

import com.cloud.simpleusermanagement.domain.User;

import java.time.Instant;
import java.util.UUID;

public interface UserRepository {
    User save(User aggregate);

    User getByUUID(UUID uuid);

    User getByUUIDat(UUID uuid, Instant at);
}
