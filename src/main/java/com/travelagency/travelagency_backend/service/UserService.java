package com.travelagency.travelagency_backend.service;

import com.travelagency.travelagency_backend.model.User;
import com.travelagency.travelagency_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Register a new user.
     *
     * @param user The User object to be saved.
     * @return The saved User object.
     */
    public User registerUser(User user) {
        // You can add additional checks or processing here if needed
        return userRepository.save(user);
    }

    /**
     * Retrieve a user by their email address.
     *
     * @param email The email of the user.
     * @return An Optional containing the user if found.
     */
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email));
    }

    /**
     * Retrieve all users.
     *
     * @return A list of all users.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Retrieve a user by their ID.
     *
     * @param id The ID of the user.
     * @return An Optional containing the User if found.
     */
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Update user information.
     *
     * @param id The ID of the user to update.
     * @param updatedUser The updated user data.
     * @return The updated User object.
     */
    public User updateUser(Long id, User updatedUser) {
        User existingUser = getUserById(id).orElseThrow(() -> new RuntimeException("User not found"));

        // You can set the updated fields here
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPhone(updatedUser.getPhone());
        // Add other fields as needed

        return userRepository.save(existingUser);
    }

    /**
     * Delete a user by their ID.
     *
     * @param id The ID of the user to delete.
     */
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}
