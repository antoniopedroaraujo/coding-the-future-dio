package me.dio.coding_the_future_gft.service.impl;

import me.dio.coding_the_future_gft.model.User;
import me.dio.coding_the_future_gft.repository.UserRepository;
import me.dio.coding_the_future_gft.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This user ID already exists");
        }
        return userRepository.save(userToCreate);
    }
}
