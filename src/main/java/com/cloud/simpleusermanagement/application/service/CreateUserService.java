package com.cloud.simpleusermanagement.application.service;

import com.cloud.simpleusermanagement.application.port.in.CreateUserUseCase;
import com.cloud.simpleusermanagement.application.port.out.SourceUserPort;
import com.cloud.simpleusermanagement.domain.User;
import com.cloud.simpleusermanagement.domain.UserState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.cloud.simpleusermanagement.domain.User.NONE;

@RequiredArgsConstructor
@Component
public class CreateUserService implements CreateUserUseCase {

    // save (source event) to event store
    private final SourceUserPort sourceUserPort;

    @Override
    public void createUser(CreateUserCommand command) {
        User user = NONE.create(
                UserState.ACTIVATED,
                command.getName(),
                command.getEmail(),
                command.getIndividualUii(),
                command.getContactNumber());
        this.sourceUserPort.source(user);
    }
}
