package com.example.academyinvestree.service.user;

import com.example.academyinvestree.model.User;
import com.example.academyinvestree.model.response.Response;

public interface UserService {
    Response registerUsers(User user);
    Response login(User user);
    int resetPassword(User user);
    int editUser(Long id,User user);
    int logout(Long id);
    User showProfile(Long id);
}
