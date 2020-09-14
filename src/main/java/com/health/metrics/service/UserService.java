package com.health.metrics.service;

import com.health.metrics.repository.UserRepository;
import com.health.metrics.dto.UserDTO;
import com.health.metrics.entity.User;
import com.health.metrics.mapper.UserMapper;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ravibeli
 * @project accessing-data-rest
 * @created on 11 Sep, 2020 7:18 PM
 **/

@Slf4j
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(UserDTO userDTO){
        User user = Mappers.getMapper(UserMapper.class).toUser(userDTO);
        return userRepository.save(user);
    }

    public User getUserByEmailId(String emailId) {
        // Validation is pending - consuming too much time, putting it in TODO list
        User user = userRepository.findByEmailId(emailId);
        return user;
    }

    public List<UserDTO> getAllUsers() {
        // Validation is pending - consuming too much time, putting it in TODO list
        List<User> users = (List<User>) userRepository.findAll();
        return Mappers.getMapper(UserMapper.class).toUserDTOList(users);
    }

}
