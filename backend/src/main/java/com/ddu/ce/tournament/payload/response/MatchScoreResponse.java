package com.ddu.ce.tournament.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class MatchScoreResponse {

    private int match_id ;
    private String team1;
    private String team2 ;

    private int team1_score;
    private int team2_score;
    private int team1_wickets;
    private int team2_wickets;

    public MatchScoreResponse(int match_id, String team1, String team2, int team1_score, int team2_score, int team1_wickets, int team2_wickets) {
        this.match_id = match_id;
        this.team1 = team1;
        this.team2 = team2;
        this.team1_score = team1_score;
        this.team2_score = team2_score;
        this.team1_wickets = team1_wickets;
        this.team2_wickets = team2_wickets;
    }

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public int getTeam1_score() {
        return team1_score;
    }

    public void setTeam1_score(int team1_score) {
        this.team1_score = team1_score;
    }

    public int getTeam2_score() {
        return team2_score;
    }

    public void setTeam2_score(int team2_score) {
        this.team2_score = team2_score;
    }

    public int getTeam1_wickets() {
        return team1_wickets;
    }

    public void setTeam1_wickets(int team1_wickets) {
        this.team1_wickets = team1_wickets;
    }

    public int getTeam2_wickets() {
        return team2_wickets;
    }

    public void setTeam2_wickets(int team2_wickets) {
        this.team2_wickets = team2_wickets;
    }

    public MatchScoreResponse() {
    }

}
