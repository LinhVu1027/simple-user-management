package com.cloud.simpleusermanagement.adapter.api;

import com.cloud.simpleusermanagement.application.port.in.ChangeNameUserUseCase;
import com.cloud.simpleusermanagement.application.port.in.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.cloud.simpleusermanagement.application.port.in.ChangeNameUserUseCase.*;
import static com.cloud.simpleusermanagement.application.port.in.CreateUserUseCase.*;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final ChangeNameUserUseCase changeNameUserUseCase;

    @PostMapping
    public void create(@RequestBody CreateUserRequest request) {
        CreateUserCommand command = new CreateUserCommand(
                request.getName(),
                request.getEmail(),
                request.getIndividualUii(),
                request.getContactNumber());
        this.createUserUseCase.createUser(command);
    }

    @PutMapping("/{uuid}/changeName")
    public void changeName(@PathVariable UUID uuid, @RequestBody ChangeNameUserRequest request) {
        ChangeNameUserCommand command = new ChangeNameUserCommand(
                uuid,
                request.getName());
        this.changeNameUserUseCase.changeName(command);
    }


}
