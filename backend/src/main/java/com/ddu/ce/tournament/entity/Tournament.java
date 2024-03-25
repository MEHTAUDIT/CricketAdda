package com.ddu.ce.tournament.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String tournament_name;
    private String tournament_type;

    @ManyToMany
    @JoinTable(
            name = "tournament_teams",
            joinColumns = @JoinColumn(name = "tournament_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    private List<Team> teams;

    private String start_date;



    public int getId() {
        return id;
    }

    public void setId(int tournament_id) {
        this.id = tournament_id;
    }

    public String getTournament_name() {
        return tournament_name;
    }

    public void setTournament_name(String tournament_name) {
        this.tournament_name = tournament_name;
    }

    public String getTournament_type() {
        return tournament_type;
    }

    public void setTournament_type(String tournament_type) {
        this.tournament_type = tournament_type;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "id=" + id +
                ", tournament_name='" + tournament_name + '\'' +
                ", tournament_type='" + tournament_type + '\'' +
                ", teams=" + teams +
                ", start_date='" + start_date + '\'' +
                '}';
    }

    public Tournament() {
    }

    public Tournament(int tournament_id, String tournament_name, String tournament_type, List<Team> teams, String start_date) {
        this.id = tournament_id;
        this.tournament_name = tournament_name;
        this.tournament_type = tournament_type;
        this.teams = teams;
        this.start_date = start_date;
    }

    public Tournament(String tournament_name, String tournament_type, List<Team> teams, String start_date) {
        this.tournament_name = tournament_name;
        this.tournament_type = tournament_type;
        this.teams = teams;
        this.start_date = start_date;
    }

    public Tournament(String tournament_name, String tournament_type, String start_date) {
        this.tournament_name = tournament_name;
        this.tournament_type = tournament_type;
        this.start_date = start_date;
    }

    public Tournament(int tournament_id, String tournament_name, String tournament_type, String start_date) {
        this.id = tournament_id;
        this.tournament_name = tournament_name;
        this.tournament_type = tournament_type;
        this.start_date = start_date;
    }

    public Tournament(String tournament_name) {
        this.tournament_name = tournament_name;
    }

    public Tournament(int tournament_id, String tournament_name) {
        this.id = tournament_id;
        this.tournament_name = tournament_name;
    }

    public Tournament(String tournament_name, String tournament_type, List<Team> teams) {
        this.tournament_name = tournament_name;
        this.tournament_type = tournament_type;
        this.teams = teams;
    }

    public Tournament(int tournament_id, String tournament_name, String tournament_type, List<Team> teams) {
        this.id = tournament_id;
        this.tournament_name = tournament_name;
        this.tournament_type = tournament_type;
        this.teams = teams;
    }

    public Tournament(String tournament_name, List<Team> teams) {
        this.tournament_name = tournament_name;
        this.teams = teams;
    }

    public Tournament(int tournament_id, String tournament_name, List<Team> teams) {
        this.id = tournament_id;
        this.tournament_name = tournament_name;
        this.teams = teams;
    }

    public Tournament(String tournament_name, String tournament_type) {
        this.tournament_name = tournament_name;
        this.tournament_type = tournament_type;
    }

    public Tournament(int tournament_id, String tournament_name, String tournament_type) {
        this.id = tournament_id;
        this.tournament_name = tournament_name;
        this.tournament_type = tournament_type;
    }

}
