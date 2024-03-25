package com.ddu.ce.tournament.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

public class MatchRequest {

    private int team1_id;
    private int team2_id;
    private int tournament_id;
    private Date match_date;

    public int getTeam1_id() {
        return team1_id;
    }

    public void setTeam1_id(int team1_id) {
        this.team1_id = team1_id;
    }

    public int getTeam2_id() {
        return team2_id;
    }

    public void setTeam2_id(int team2_id) {
        this.team2_id = team2_id;
    }

    public int getTournament_id() {
        return tournament_id;
    }

    public void setTournament_id(int tournament_id) {
        this.tournament_id = tournament_id;
    }

    public Date getMatch_date() {
        return match_date;
    }

    public void setMatch_date(Date match_date) {
        this.match_date = match_date;
    }

    @Override
    public String toString() {
        return "MatchRequest{" +
                "team1_id=" + team1_id +
                ", team2_id=" + team2_id +
                ", tournament_id=" + tournament_id +
                ", match_date=" + match_date +
                '}';
    }


}
