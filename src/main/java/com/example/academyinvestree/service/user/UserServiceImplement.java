package com.example.academyinvestree.service.user;

import com.example.academyinvestree.model.User;
import com.example.academyinvestree.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserServiceImplement")
public class UserServiceImplement implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public int registerUsers(User user) {
        this.userRepository.save(user);

        return 200;
    }

    @Override
    public int login(User user) {
        return 0;
    }

    @Override
    public int resetPassword(User user) {
        return 0;
    }

    @Override
    public int editUser(Long id, User user) {
        return 0;
    }

    @Override
    public int logout(Long id) {
        return 0;
    }

    @Override
    public User showProfile(Long id) {
        return null;
    }
}
