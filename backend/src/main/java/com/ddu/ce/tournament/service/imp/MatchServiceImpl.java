package com.ddu.ce.tournament.service.imp;

import com.ddu.ce.tournament.dao.MatchDAO;
import com.ddu.ce.tournament.entity.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class MatchServiceImpl implements com.ddu.ce.tournament.service.MatchService{

    private MatchDAO matchDAO;

    @Autowired
    public MatchServiceImpl(MatchDAO matchDAO) {
        this.matchDAO = matchDAO;
    }

    public MatchDAO getMatchDAO() {
        return matchDAO;
    }

    public Match updateMatchScore(int matchId, int team1Score, int team2Score, int team1Wickets, int team2Wickets) {
        Match match = matchDAO.findById(matchId).get();
        match.setTeam1_score(team1Score);
        match.setTeam2_score(team2Score);
        match.setTeam1_wickets(team1Wickets);
        match.setTeam2_wickets(team2Wickets);
        matchDAO.save(match);
        return match;
    }

    public void setMatchDAO(MatchDAO matchDAO) {
        this.matchDAO = matchDAO;
    }

    public void save(Match match) {
        matchDAO.save(match);
    }

    public Match findById(int id) {
        return matchDAO.findById(id).get();
    }

    public void deleteById(int id) {
        matchDAO.deleteById(id);
    }

    public Iterable<Match> findAll() {
        return matchDAO.findAll();
    }

    public void deleteAll() {
        matchDAO.deleteAll();
    }

}
