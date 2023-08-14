package com.example.week04d2homework.Service;

import com.example.week04d2homework.Model.User;
import com.example.week04d2homework.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> updateUser(Integer id, User user) {
        Optional<User> saved_user_optional = userRepository.findById(id);

        if(saved_user_optional.isPresent()) {
            User saved_user = saved_user_optional.get();

            saved_user.setName(user.getName());
            saved_user.setAge(user.getAge());
            saved_user.setPassword(user.getPassword());
            saved_user.setRole(user.getRole());
            saved_user.setUsername(user.getUsername());
            saved_user.setEmail(user.getEmail());

            userRepository.save(saved_user);

            return saved_user_optional;
        }

        return Optional.empty();
    }

    public Optional<User> deleteUser(Integer id) {
        Optional<User> saved_user_optional = userRepository.findById(id);

        if(saved_user_optional.isPresent()) {
            userRepository.deleteById(id);
            return saved_user_optional;
        }

        return Optional.empty();
    }
}
