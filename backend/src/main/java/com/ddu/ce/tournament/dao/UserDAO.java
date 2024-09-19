package com.ddu.ce.tournament.dao;

import com.ddu.ce.tournament.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

   Optional<User> findByEmail(String email);
}
