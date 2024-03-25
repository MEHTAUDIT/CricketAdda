package com.ddu.ce.tournament.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String team_name;


//    @OneToMany(mappedBy = "team")
//    private List<Player> players;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }


    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", team_name='" + team_name + '\'' +
                '}';
    }

}
