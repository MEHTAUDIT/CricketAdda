package com.ddu.ce.tournament.service.imp;

import com.ddu.ce.tournament.dao.PlayerDAO;
import com.ddu.ce.tournament.dao.TeamDAO;
import com.ddu.ce.tournament.entity.Player;
import com.ddu.ce.tournament.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements com.ddu.ce.tournament.service.TeamService{

    private TeamDAO teamDAO;
    private PlayerDAO playerDAO;

    @Autowired
    public TeamServiceImpl(TeamDAO teamDAO , PlayerDAO playerDAO) {
        this.teamDAO = teamDAO;
        this.playerDAO = playerDAO;

    }

    public TeamDAO getTeamDAO()
    {
        return teamDAO;
    }

    public void setTeamDAO(TeamDAO teamDAO){
        this.teamDAO = teamDAO;
    }

    public String save(Team team)
    {
        teamDAO.save(team);
        return "Team saved";
    }

    public Team findById(int id){
        return teamDAO.findById(id).get();
    }

    public String deleteById(int id){
        teamDAO.deleteById(id);
        return "Team deleted";
    }

    public Iterable<Team> findAll(){
        return teamDAO.findAll();
    }

    public void deleteAll(){
        teamDAO.deleteAll();
    }

    public String addPlayerToTeam(int team_id, int player_id) {
        Team team = teamDAO.findById(team_id).get();
        Player player = playerDAO.findById(player_id).get();
        player.setTeam(team);
        playerDAO.save(player);
        return "Player added to team";

    }

    public List<Player> getPlayers(int team_id) {


        List<Player> players = playerDAO.findByTeamId(team_id);
        for (Player player : players) {
            System.out.println(player.getName());
        }
        return players;
    }

    public String deletePlayerFromTeam(int team_id, int player_id) {
        Player player = playerDAO.findById(player_id).get();
        player.setTeam(null);
        playerDAO.save(player);
        return "Player deleted from team";
    }

}
