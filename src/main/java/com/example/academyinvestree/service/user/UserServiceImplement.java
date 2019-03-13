package com.example.academyinvestree.service.user;

import com.example.academyinvestree.model.User;
import com.example.academyinvestree.model.response.MetaResponse;
import com.example.academyinvestree.model.response.Response;
import com.example.academyinvestree.repository.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

@Service("UserServiceImplement")
public class UserServiceImplement implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Response registerUsers(User user) {
        User user2 = new User();
        String sha256hex = DigestUtils.sha256Hex(user.getPassword());

        user2.setFull_name(user.getFull_name());
        user2.setEmail(user.getEmail());
        user2.setUsername(user.getUsername());
        user2.setPassword(sha256hex);
        user2.setCreated_at(new Timestamp(System.currentTimeMillis()));
        user2.setStatus(1);
        user2.setIs_login(0);

        this.userRepository.save(user2);
        Response response = new Response();
        response.setStatus("OK");

        MetaResponse metaResponse = new MetaResponse();
        metaResponse.setCode("200");
        metaResponse.setDebugInfo("");
        metaResponse.setMessage("success");
        response.setMeta(metaResponse);


        return response;
    }

    @Override
    public Response login(User user) {
        User user1 = userRepository.findByUsername(user.getUsername());
        String sha256hex = DigestUtils.sha256Hex(user.getPassword());

        if(user1 != null) {
            if(user1.getPassword().equalsIgnoreCase(sha256hex)){
                user1.setIs_login(1);
                this.userRepository.save(user1);

                Response response = new Response();
                response.setStatus("OK");

                MetaResponse metaResponse = new MetaResponse();
                metaResponse.setCode("200");
                metaResponse.setDebugInfo("");
                metaResponse.setMessage("success");
                response.setMeta(metaResponse);

                return response;
            }else{
                Response response = new Response();
                response.setStatus("Gagal");

                MetaResponse metaResponse = new MetaResponse();
                metaResponse.setCode("200");
                metaResponse.setDebugInfo("");
                metaResponse.setMessage("Incorect Username or Password");
                response.setMeta(metaResponse);

                return response;
            }
        }else{
            Response response = new Response();
            response.setStatus("Not Found");

            MetaResponse metaResponse = new MetaResponse();
            metaResponse.setCode("404");
            metaResponse.setDebugInfo("");
            metaResponse.setMessage("data doesnt match");
            response.setMeta(metaResponse);

            return response;
        }
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
