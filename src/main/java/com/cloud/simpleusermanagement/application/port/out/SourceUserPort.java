package com.cloud.simpleusermanagement.application.port.out;

import com.cloud.simpleusermanagement.domain.User;

public interface SourceUserPort {
    void source(User user);
}
