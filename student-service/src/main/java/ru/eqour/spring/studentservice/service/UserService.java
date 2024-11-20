package ru.eqour.spring.studentservice.service;

import ru.eqour.spring.studentservice.dto.UserDto;
import ru.eqour.spring.studentservice.entity.User;

import java.util.List;

public interface UserService {

    void saveUser(UserDto userDto);
    User findUserByEmail(String email);
    List<UserDto> findAllUsers();
}
