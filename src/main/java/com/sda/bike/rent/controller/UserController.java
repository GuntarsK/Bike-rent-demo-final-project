package com.sda.bike.rent.controller;

import com.sda.bike.rent.dto.Response;
import com.sda.bike.rent.dto.ResponseMapper;
import com.sda.bike.rent.dto.UserDTO;
import com.sda.bike.rent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/rest/user.svc")
@CrossOrigin
public class UserController {

    private final UserService userService;
    private final ResponseMapper responseMapper;

    @Autowired
    public UserController(UserService userService, ResponseMapper responseMapper) {
        this.userService = userService;
        this.responseMapper = responseMapper;
    }

    @PostMapping("/user")
    public Response response (@Valid @RequestBody UserDTO userDTO) {
        if (userService.doesEmailExist(userDTO.getEmail())) {
            return responseMapper.mapFail("Email: " + userDTO.getEmail() + " already exists!", "WARNING");
        }
        return responseMapper
                .mapSuccess(userService.createUser(userDTO));
    }

    @GetMapping("/users")
    public Response getAllUsers() {
        return responseMapper
                .mapSuccess(userService.getUsers());
    }

    @GetMapping("/user({id})")
    public Response getUserById(@PathVariable("id") Long id) {
        return responseMapper
                .mapSuccess(userService.getUserById(id));
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserDTO userDTO) {
        userService.updateUser(userDTO);
    }

    @PostMapping("/users/search")
    public Response search(@RequestBody UserDTO userDTO) {
        return responseMapper
                .mapSuccess(userService.search(userDTO));
    }

    @DeleteMapping("/user({id})")
    public Response deleteUser(@PathVariable("id") Long id) {
        return responseMapper
                .mapSuccess(userService.deleteUser(id));
    }


//    @PostMapping("/users/search")
//    public List<UserDTO> search(@RequestBody UserDTO userDTO) {
//        return userService.search(userDTO);
//    }

//    @PostMapping("/user")
//    public UserDTO createUser(@Valid @RequestBody UserDTO userDTO) {
//        return userService.createUser(userDTO);
//    }

//    @GetMapping("/users")
//    public List<UserDTO> getAllUsers() {
//        return userService.getUsers();
//    }

//    @GetMapping("/user({id})")
//    public UserDTO getUserById(@PathVariable(name = "id") Long id) {
//        return userService.getUserById(id);
//    }




}
