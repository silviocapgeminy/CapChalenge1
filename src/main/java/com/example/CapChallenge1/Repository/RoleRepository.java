package com.example.CapChallenge1.Repository;

import com.example.CapChallenge1.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
