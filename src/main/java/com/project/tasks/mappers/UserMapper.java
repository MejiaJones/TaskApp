package com.project.tasks.mappers;

import com.project.tasks.domain.dto.UserDto;
import com.project.tasks.domain.entities.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDto dto);
    UserDto toDto(User user);
}