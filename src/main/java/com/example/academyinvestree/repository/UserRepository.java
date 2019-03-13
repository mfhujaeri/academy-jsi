package com.example.academyinvestree.repository;

import com.example.academyinvestree.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
