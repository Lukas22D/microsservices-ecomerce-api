package app.user_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import app.user_service.controller.dto.CreateUserRequest;
import app.user_service.controller.dto.Response200;
import app.user_service.controller.dto.UserReponse;
import app.user_service.service.UserService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserReponse> createUser(@RequestBody CreateUserRequest request) {
        return ResponseEntity.ok().body(userService.saveUser(request));
    }

    @GetMapping("/")
    public ResponseEntity<Response200> findAllUser() {
        var users = userService.getAllUsers();
        return new ResponseEntity<>(new Response200("SUCESS", HttpStatus.OK.value(), users), HttpStatus.OK);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Response200> updateUser(@RequestBody CreateUserRequest user, @PathVariable("id") Long id) {
        var userUpdate = userService.updateUser(id, user);
        return new ResponseEntity<>(new Response200("UPDATE", HttpStatus.OK.value(), userUpdate), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response200> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(new Response200("DELETE", HttpStatus.OK.value(), null), HttpStatus.OK);
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Response200> getUserById(@PathVariable("id") Long id) {
        var user = userService.getUserById(id);
        return new ResponseEntity<>(new Response200("SUCESS", HttpStatus.OK.value(), user), HttpStatus.OK);
    }
    
}
