package com.ddu.ce.tournament.dao;


import com.ddu.ce.tournament.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ddu.ce.tournament.entity.URole;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(URole name);
}
