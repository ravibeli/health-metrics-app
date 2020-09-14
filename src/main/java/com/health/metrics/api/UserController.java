package com.health.metrics.api;

import com.health.metrics.dto.UserDTO;
import com.health.metrics.entity.User;
import com.health.metrics.service.UserService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ravibeli
 * @project accessing-data-rest
 * @created on 11 Sep, 2020 5:47 PM
 **/

@Slf4j
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    @RequestMapping(params = {"emailId"})
    public ResponseEntity<User> getUser(@RequestParam("emailId") String emailId) {
        log.info("EmailId from RequestParam = {}", emailId);
        User user = userService.getUserByEmailId(emailId);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<UserDTO> userDTOs = userService.getAllUsers();
        return new ResponseEntity<>(userDTOs, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
        log.info("In DeviceController.createUser({})", userDTO);
        User user = userService.createUser(userDTO);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
