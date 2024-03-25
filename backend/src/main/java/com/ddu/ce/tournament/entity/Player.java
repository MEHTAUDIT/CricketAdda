package com.ddu.ce.tournament.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String role;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
    private Team team;

    public int getId() {
        return id;
    }

    public void setId(int player_id) {
        this.id = player_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String player_name) {
        this.name = player_name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String player_role) {
        this.role = player_role;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team player_team) {
        this.team = player_team;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", team=" + team +
                '}';
    }

    public Player() {
    }

    public Player(int player_id, String player_name, String player_role, Team player_team) {
        this.id = player_id;
        this.name = player_name;
        this.role = player_role;
        this.team = player_team;
    }

    public Player(String player_name, String player_role, Team player_team) {
        this.name = player_name;
        this.role = player_role;
        this.team = player_team;
    }

    public Player(String player_name, String player_role) {
        this.name = player_name;
        this.role = player_role;
    }

    public Player(int player_id, String player_name, String player_role) {
        this.id = player_id;
        this.name = player_name;
        this.role = player_role;
    }

    public Player(String player_name) {
        this.name = player_name;
    }

    public Player(int player_id, String player_name) {
        this.id = player_id;
        this.name = player_name;
    }

    public Player(String player_name, String player_role, int team_id) {
        this.name = player_name;
        this.role = player_role;
        this.team = new Team();
        this.team.setId(team_id);
    }

    public Player(int player_id, String player_name, String player_role, int team_id) {
        this.id = player_id;
        this.name = player_name;
        this.role = player_role;
        this.team = new Team();
        this.team.setId(team_id);
    }

    public Player(String player_name, int team_id) {
        this.name = player_name;
        this.team = new Team();
        this.team.setId(team_id);
    }

    public Player(int player_id, String player_name, int team_id) {
        this.id = player_id;
        this.name = player_name;
        this.team = new Team();
        this.team.setId(team_id);
    }


}
