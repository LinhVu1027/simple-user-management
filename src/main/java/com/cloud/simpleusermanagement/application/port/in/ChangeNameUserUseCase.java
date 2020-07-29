package com.cloud.simpleusermanagement.application.port.in;

import com.cloud.simpleusermanagement.application.SelfValidating;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public interface ChangeNameUserUseCase {
    void changeName(ChangeNameUserCommand command);

    @Value
    @EqualsAndHashCode(callSuper = false)
    class ChangeNameUserCommand extends SelfValidating<ChangeNameUserCommand> {
        @NotNull
        private UUID uuid;
        @NotEmpty
        private String name;

        public ChangeNameUserCommand(UUID uuid, String name) {
            this.uuid = uuid;
            this.name = name;
            this.validateSelf();
        }
    }
}
