package com.ddu.ce.tournament.entity;

import jakarta.persistence.*;

@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int match_id;
    private String match_status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team1_id", referencedColumnName = "team_id")
    private Team team1;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team2_id", referencedColumnName = "team_id")
    private Team team2;

    private int winner;

}
