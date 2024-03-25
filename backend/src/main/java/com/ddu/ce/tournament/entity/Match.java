package com.ddu.ce.tournament.entity;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

@Entity
@Table(name = "tournament_match")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String match_status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team1_id")
    private Team team1;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team2_id")
    private Team team2;

    @Temporal(TemporalType.DATE)
    private Date match_date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    @Value("0")
    private int team1_score;
    @Value("0")
    private int team2_score;
    @Value("0")
    private int team1_wickets;
    @Value("0")
    private int team2_wickets;


    private int winner;

    public int getId() {
        return id;
    }

    public void setId(int match_id) {
        this.id = match_id;
    }

    public String getMatch_status() {
        return match_status;
    }

    public void setMatch_status(String match_status) {
        this.match_status = match_status;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    public Date getMatch_date() {
        return match_date;
    }

    public void setMatch_date(Date match_date) {
        this.match_date = match_date;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
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

    public Match() {
    }



}
