package com.ddu.ce.tournament;

import com.ddu.ce.tournament.dao.MatchDAO;
import com.ddu.ce.tournament.dao.PlayerDAO;
import com.ddu.ce.tournament.dao.TeamDAO;
import com.ddu.ce.tournament.dao.TournamentDAO;
import com.ddu.ce.tournament.entity.Tournament;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TournamentApplication {

	public static void main(String[] args) {
		SpringApplication.run(TournamentApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner (PlayerDAO playerDAO, TeamDAO teamDAO, TournamentDAO tournamentDAO, MatchDAO matchDAO) {
		return runner->{
//			Tournament myTournament = new Tournament();

		};
	}

}
