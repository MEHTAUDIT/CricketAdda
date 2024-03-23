package com.ddu.ce.tournament.dao;

import com.ddu.ce.tournament.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentDAO extends JpaRepository<Tournament, Integer>{


}
