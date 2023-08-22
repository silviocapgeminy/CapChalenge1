package com.example.CapChallenge1.Service;


import com.example.CapChallenge1.Model.User;
import com.example.CapChallenge1.dto.UserDto;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByName(String name);

    List<UserDto> findAllUsers();
}
