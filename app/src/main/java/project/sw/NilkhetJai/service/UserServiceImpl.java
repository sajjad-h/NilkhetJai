package project.sw.NilkhetJai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.sw.NilkhetJai.models.User;
import project.sw.NilkhetJai.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User User) {
        return userRepository.save(User);
    }

    @Override
    public Optional<User> findById(Long UserId) {
        return userRepository.findById(UserId);
    }

    @Override
    public Optional<User> findByEmail(String UserEmail) {
        return userRepository.findByEmail(UserEmail);
    }
}
