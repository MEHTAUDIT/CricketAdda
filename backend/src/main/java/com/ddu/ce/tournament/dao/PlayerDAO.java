package com.ddu.ce.tournament.dao;

import com.ddu.ce.tournament.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerDAO extends JpaRepository<Player, Integer>{

    public List<Player> findByTeamId(int team_id);
}
