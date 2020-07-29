package com.cloud.simpleusermanagement.application.port.out;

import com.cloud.simpleusermanagement.domain.User;

import java.util.UUID;

public interface FindUserPort {
    User find(UUID uuid);
}
