package com.ddu.ce.tournament.dao;

import com.ddu.ce.tournament.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchDAO extends JpaRepository<Match, Integer> {
}
