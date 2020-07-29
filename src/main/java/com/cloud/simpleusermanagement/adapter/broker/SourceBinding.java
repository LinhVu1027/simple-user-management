package com.cloud.simpleusermanagement.adapter.broker;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface SourceBinding {
    String USERS_OUT = "usersv1";

    @Output(USERS_OUT)
    MessageChannel usersOut();
}
