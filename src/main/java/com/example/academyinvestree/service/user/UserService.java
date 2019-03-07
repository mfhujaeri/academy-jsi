package com.example.academyinvestree.service.user;

import com.example.academyinvestree.model.User;

public interface UserService {
    int registerUsers(User user);
    int login(User user);
    int resetPassword(User user);
    int editUser(Long id,User user);
    int logout(Long id);
    User showProfile(Long id);
}
