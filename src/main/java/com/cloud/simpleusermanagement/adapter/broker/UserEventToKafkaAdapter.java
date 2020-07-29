package com.cloud.simpleusermanagement.adapter.broker;

import com.cloud.simpleusermanagement.application.port.out.SendUserEventToBroker;
import com.cloud.simpleusermanagement.domain.event.DomainEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserEventToKafkaAdapter implements SendUserEventToBroker {
    private final MessageChannel usersOut;

    public UserEventToKafkaAdapter(SourceBinding binding) {
        this.usersOut = binding.usersOut();
    }

    @Override
    public void send(DomainEvent event) {
        Message<DomainEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.MESSAGE_KEY, event.uuid().toString().getBytes())
                .build();
        try {
            this.usersOut.send(message);
            log.info("Sent: " + message.toString());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
