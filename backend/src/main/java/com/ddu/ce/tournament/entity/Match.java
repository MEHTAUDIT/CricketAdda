package com.ddu.ce.tournament.entity;

import jakarta.persistence.*;

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




}
