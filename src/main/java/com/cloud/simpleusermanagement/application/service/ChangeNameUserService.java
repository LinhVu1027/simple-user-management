package com.cloud.simpleusermanagement.application.service;

import com.cloud.simpleusermanagement.application.port.in.ChangeNameUserUseCase;
import com.cloud.simpleusermanagement.application.port.out.FindUserPort;
import com.cloud.simpleusermanagement.application.port.out.SourceUserPort;
import com.cloud.simpleusermanagement.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ChangeNameUserService implements ChangeNameUserUseCase {

    private final FindUserPort findUserPort;
    private final SourceUserPort sourceUserPort;

    @Override
    public void changeName(ChangeNameUserCommand command) {
        User user = this.findUserPort.find(command.getUuid());
        user.changeName(command.getName());
        this.sourceUserPort.source(user);
    }
}
