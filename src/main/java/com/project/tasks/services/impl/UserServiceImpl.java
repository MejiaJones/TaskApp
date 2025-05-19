package com.project.tasks.services.impl;

import com.project.tasks.domain.dto.UserDto;
import com.project.tasks.domain.entities.User;
import com.project.tasks.mappers.UserMapper;
import com.project.tasks.repositories.UserRepository;
import com.project.tasks.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        userRepository.save(user);
        return userMapper.toDto(user);
    }
}
