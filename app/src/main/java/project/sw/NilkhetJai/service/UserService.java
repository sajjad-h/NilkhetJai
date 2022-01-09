package project.sw.NilkhetJai.service;

import java.util.Optional;

import project.sw.NilkhetJai.models.User;

public interface UserService {
    User save(User User);

    Optional<User> findById(Long userId);

    Optional<User> findByEmail(String email);
}
