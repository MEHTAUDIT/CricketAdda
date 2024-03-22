package com.ddu.ce.tournament.dao;

import com.ddu.ce.tournament.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamDAO extends JpaRepository<Team, Integer> {
}
