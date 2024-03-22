package com.ddu.ce.tournament.dao;

import com.ddu.ce.tournament.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerDAO extends JpaRepository<Player, Integer>{
}
