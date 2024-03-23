package com.ddu.ce.tournament.dao;

import com.ddu.ce.tournament.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchDAO extends JpaRepository<Match, Integer> {

    public List<Match> findByTournament_Id(int tournament_id);
}
