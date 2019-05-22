package hu.flowacademy.FlowRatr.controller;

import hu.flowacademy.FlowRatr.domain.User;
import hu.flowacademy.FlowRatr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @PutMapping("/update")
    public ResponseEntity<User> modUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.update(user));
    }

}
