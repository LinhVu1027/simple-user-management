package com.cloud.simpleusermanagement.config;

import com.cloud.simpleusermanagement.adapter.broker.SourceBinding;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding({
        SourceBinding.class,
})
public class KafkaConfig {
}
