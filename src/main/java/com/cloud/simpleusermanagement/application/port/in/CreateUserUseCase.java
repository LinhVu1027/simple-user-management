package com.cloud.simpleusermanagement.application.port.in;

import com.cloud.simpleusermanagement.application.SelfValidating;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.NotEmpty;

public interface CreateUserUseCase {
    void createUser(CreateUserCommand command);

    @Value
    @EqualsAndHashCode(callSuper = false)
    class CreateUserCommand extends SelfValidating<CreateUserCommand> {
        @NotEmpty
        private String name;
        @NotEmpty
        private String email;
        @NotEmpty
        private String individualUii;
        @NotEmpty
        private String contactNumber;

        public CreateUserCommand(String name, String email, String individualUii, String contactNumber) {
            this.name = name;
            this.email = email;
            this.individualUii = individualUii;
            this.contactNumber = contactNumber;
            this.validateSelf();
        }
    }
}
