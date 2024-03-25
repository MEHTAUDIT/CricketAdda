package com.ddu.ce.tournament.payload.request;

import lombok.Getter;
import lombok.Setter;


public class UpdateMatchScore {
    int matchId;
    int team1Score;
    int team2Score;
    int team1Wickets;
    int team2Wickets;

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getTeam1Score() {
        return team1Score;
    }

    public void setTeam1Score(int team1Score) {
        this.team1Score = team1Score;
    }

    public int getTeam2Score() {
        return team2Score;
    }

    public void setTeam2Score(int team2Score) {
        this.team2Score = team2Score;
    }

    public int getTeam1Wickets() {
        return team1Wickets;
    }

    public void setTeam1Wickets(int team1Wickets) {
        this.team1Wickets = team1Wickets;
    }

    public int getTeam2Wickets() {
        return team2Wickets;
    }

    public void setTeam2Wickets(int team2Wickets) {
        this.team2Wickets = team2Wickets;
    }

    @Override
    public String toString() {
        return "UpdateMatchScore{" +
                "matchId=" + matchId +
                ", team1Score=" + team1Score +
                ", team2Score=" + team2Score +
                ", team1Wickets=" + team1Wickets +
                ", team2Wickets=" + team2Wickets +
                '}';
    }

    public UpdateMatchScore() {
    }

    public UpdateMatchScore(int matchId, int team1Score, int team2Score, int team1Wickets, int team2Wickets) {
        this.matchId = matchId;
        this.team1Score = team1Score;
        this.team2Score = team2Score;
        this.team1Wickets = team1Wickets;
        this.team2Wickets = team2Wickets;
    }

    public UpdateMatchScore(int team1Score, int team2Score, int team1Wickets, int team2Wickets) {
        this.team1Score = team1Score;
        this.team2Score = team2Score;
        this.team1Wickets = team1Wickets;
        this.team2Wickets = team2Wickets;
    }

    public UpdateMatchScore(int team1Score, int team2Score) {
        this.team1Score = team1Score;
        this.team2Score = team2Score;
    }

    public UpdateMatchScore(int matchId, int team1Score, int team2Score) {
        this.matchId = matchId;
        this.team1Score = team1Score;
        this.team2Score = team2Score;
    }


}
