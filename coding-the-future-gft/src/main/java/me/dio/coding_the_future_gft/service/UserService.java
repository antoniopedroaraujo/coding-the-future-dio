package me.dio.coding_the_future_gft.service;

import me.dio.coding_the_future_gft.model.User;

public interface UserService {
    User findById(Long id);

    User create(User userToCreate);
}
