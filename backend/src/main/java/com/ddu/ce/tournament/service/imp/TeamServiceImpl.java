package com.ddu.ce.tournament.service.imp;

import com.ddu.ce.tournament.dao.TeamDAO;
import com.ddu.ce.tournament.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements com.ddu.ce.tournament.service.TeamService{

    private TeamDAO teamDAO;

    @Autowired
    public TeamServiceImpl(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    public TeamDAO getTeamDAO()
    {
        return teamDAO;
    }

    public void setTeamDAO(TeamDAO teamDAO){
        this.teamDAO = teamDAO;
    }

    public void save(Team team)
    {
        teamDAO.save(team);

    }

    public Team findById(int id){
        return teamDAO.findById(id).get();
    }

    public void deleteById(int id){
        teamDAO.deleteById(id);
    }

    public Iterable<Team> findAll(){
        return teamDAO.findAll();
    }

    public void deleteAll(){
        teamDAO.deleteAll();
    }



}
