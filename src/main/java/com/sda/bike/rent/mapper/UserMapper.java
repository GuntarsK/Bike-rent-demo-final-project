package com.sda.bike.rent.mapper;

import com.sda.bike.rent.dto.UserDTO;
import com.sda.bike.rent.model.User;
import com.sda.bike.rent.model.userTypeEnum.UserType;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User fromDTO(UserDTO userDTO) {
        User user = new User();

        user.setUserPk(userDTO.getUserPk());
        user.setName(userDTO.getName());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setEmail(userDTO.getEmail());
        user.setPasswordHash(userDTO.getPasswordHash());
        if (userDTO.getType() == null) {
            user.setType(null);
        } else {
            user.setType(UserType.valueOf(userDTO.getType()));
        }
        return user;
    }


    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setUserPk(user.getUserPk());
        userDTO.setName(user.getName());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setEmail(user.getEmail());
        userDTO.setPasswordHash(user.getPasswordHash());
        userDTO.setType(user.getType().name());

        return userDTO;
    }

}
