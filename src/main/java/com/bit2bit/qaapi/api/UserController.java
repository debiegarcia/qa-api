package com.bit2bit.qaapi.api;

import com.bit2bit.qaapi.domain.service.UserService;
import com.bit2bit.qaapi.mapping.UserMapper;
import com.bit2bit.qaapi.resource.CreateUserResource;
import com.bit2bit.qaapi.resource.UpdateUserResource;
import com.bit2bit.qaapi.resource.UserResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User")
@RestController
@RequestMapping("api/v1/users")
@CrossOrigin
public class UserController {

    private final UserService userService;

    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Operation(summary = "Get Users", description = "Get All Users")
    @GetMapping
    public List<UserResource> getAll(){
        return userMapper.toResource(userService.getAll());
    }

    @Operation(summary = "Get User by Id", description = "Get User by Id")
    @GetMapping("{userId}")
    public UserResource getUserById(@PathVariable Long userId){
        return userMapper.toResource(userService.getById(userId));
    }

    @Operation(summary = "Create User", description = "Create User")
    @PostMapping
    public UserResource createUser(@RequestBody CreateUserResource model){
        return userMapper.toResource(userService.create(userMapper.toModel(model)));
    }

    @Operation(summary = "Update User", description = "Update User")
    @PutMapping("{userId}")
    public UserResource updateUser(@PathVariable Long userId, @RequestBody UpdateUserResource model){
        return userMapper.toResource(userService.update(userId, userMapper.toModel(model)));
    }

    @Operation(summary = "Delete User", description = "Delete User")
    @DeleteMapping("{userId}")
    public UserResource deleteUser(@PathVariable Long userId){
        return userMapper.toResource(userService.delete(userId));
    }
}
