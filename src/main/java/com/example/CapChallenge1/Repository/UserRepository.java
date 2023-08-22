package com.example.CapChallenge1.Repository;

import com.example.CapChallenge1.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
}
