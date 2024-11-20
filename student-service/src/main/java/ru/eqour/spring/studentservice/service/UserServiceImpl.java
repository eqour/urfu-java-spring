package ru.eqour.spring.studentservice.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.eqour.spring.studentservice.dto.UserDto;
import ru.eqour.spring.studentservice.entity.Role;
import ru.eqour.spring.studentservice.entity.User;
import ru.eqour.spring.studentservice.repository.RoleRepository;
import ru.eqour.spring.studentservice.repository.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Role role = getOrCreateAdminRole();
        user.setRoles(Collections.singletonList(role));
        userRepository.save(user);
    }

    private Role getOrCreateAdminRole() {
        String adminRoleName = "ROLE_ADMIN";
        Optional<Role> roleOptional = roleRepository.findByName(adminRoleName);
        if (roleOptional.isPresent()) {
            return roleOptional.get();
        } else {
            Role role = new Role();
            role.setName(adminRoleName);
            roleRepository.save(role);
            return roleRepository.findByName(adminRoleName).orElseThrow();
        }
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public List<UserDto> findAllUsers() {
        return userRepository.findAll().stream()
                .map(this::mapUserToDto)
                .collect(Collectors.toList());
    }

    private UserDto mapUserToDto(User user) {
        UserDto userDto = new UserDto();
        String[] splitName = user.getName().split(" ");
        userDto.setFirstName(splitName[0]);
        userDto.setLastName(splitName[1]);
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
