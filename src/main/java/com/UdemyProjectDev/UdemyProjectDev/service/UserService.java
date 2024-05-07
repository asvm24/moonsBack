package com.UdemyProjectDev.UdemyProjectDev.service;


import com.UdemyProjectDev.UdemyProjectDev.enums.UserRole;
import com.UdemyProjectDev.UdemyProjectDev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.UdemyProjectDev.UdemyProjectDev.model.User;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }

    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User createUser(String email, UserRole userRole, String phoneNumber) {
        User user = new User(email, userRole, phoneNumber);
        return userRepository.save(user);
    }

    public User deleteUser(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            userRepository.delete(user);
            return user;
        }
        return null; // Or throw an exception if user not found
    }

    public User updateUser(String email, Map<String, Object> updates) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            for (Map.Entry<String, Object> entry : updates.entrySet()) {
                String fieldName = entry.getKey();
                Object value = entry.getValue();
                try {
                    Field field = User.class.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    if(fieldName.equals("userRole"))
                        value = UserRole.valueOf(value.toString());
                    field.set(user, value);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    throw new IllegalArgumentException("Unsupported field: " + fieldName, e);
                }
            }
            return userRepository.save(user);
        }
        return null; // Or throw an exception if user not found
    }
}