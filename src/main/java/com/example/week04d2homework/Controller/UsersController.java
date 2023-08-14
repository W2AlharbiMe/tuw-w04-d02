package com.example.week04d2homework.Controller;

import com.example.week04d2homework.ApiResponse.ApiResponseWithData;
import com.example.week04d2homework.Model.User;
import com.example.week04d2homework.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UsersController {
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping("/create")
    public ResponseEntity<?> addUser(@RequestBody @Valid User user, Errors errors) {
        if(errors.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.getFieldErrors());
        }

        User savedUser = userService.createUser(user);

        return ResponseEntity.ok(savedUser);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody @Valid User user, Errors errors) {
        if(errors.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.getFieldErrors());
        }

        Optional<User> savedUser = userService.updateUser(id, user);
        String message = (savedUser.isPresent() ? "the user have been updated." : "user not found.");

        HttpStatus httpStatus = (savedUser.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);

        return ResponseEntity.status(httpStatus).body((new ApiResponseWithData<>(message, savedUser)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        Optional<User> user = userService.deleteUser(id);
        String message = (user.isPresent() ? "the user have been deleted." : "user not found.");
        HttpStatus httpStatus = (user.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);

        return ResponseEntity.status(httpStatus).body((new ApiResponseWithData<>(message, user)));
    }
}
