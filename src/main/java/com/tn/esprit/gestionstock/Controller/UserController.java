package com.tn.esprit.gestionstock.Controller;

import com.tn.esprit.gestionstock.Entities.User;
import com.tn.esprit.gestionstock.Service.User.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "User management")
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Add user ")
    @PostMapping("add")
    public User add(@Valid @RequestBody User user) {
        return userService.add(user);
    }

    @ApiOperation(value = "Update user ")
    @PutMapping("update/{id}")
    public User update(@Valid @RequestBody User user,@PathVariable("id") Long id) {
        return userService.update(user, id);
    }

    @ApiOperation(value = "Delete user")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        userService.delete(id);
    }

    @ApiOperation(value = "Retreive all users")
    @GetMapping("list")
    public List<User> findAll() {
        return userService.findAll();
    }

    @ApiOperation(value = "Find user by provided id")
    @GetMapping("findById/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }
}
