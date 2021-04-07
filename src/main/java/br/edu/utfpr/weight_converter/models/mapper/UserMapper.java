package br.edu.utfpr.weight_converter.models.mapper;

import br.edu.utfpr.weight_converter.models.domain.User;
import br.edu.utfpr.weight_converter.models.dto.UserDTO;

public class UserMapper {
    public static User toEntity(UserDTO dto) {
        User entity = new User(dto.getName());
        return entity;
    }

    public static UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO(user.getName());
        return dto;
    }
}
