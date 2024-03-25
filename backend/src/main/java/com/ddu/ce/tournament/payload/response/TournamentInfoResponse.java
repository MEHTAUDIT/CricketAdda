package com.ddu.ce.tournament.payload.response;

import com.ddu.ce.tournament.entity.Tournament;

import java.util.List;


public class TournamentInfoResponse {

    int tournament_id;
    String tournament_name;
    String tournament_type;

    String start_date;


    public TournamentInfoResponse(Tournament tournament) {
        this.tournament_id = tournament.getId();
        this.tournament_name = tournament.getTournament_name();
        this.tournament_type = tournament.getTournament_type();
        this.start_date = tournament.getStart_date();
    }

    public int getTournament_id() {
        return tournament_id;
    }

    public void setTournament_id(int tournament_id) {
        this.tournament_id = tournament_id;
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

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    @Override
    public String toString() {
        return "TournamentInfoResponse{" +
                "tournament_id=" + tournament_id +
                ", tournament_name='" + tournament_name + '\'' +
                ", tournament_type='" + tournament_type + '\'' +
                '}';
    }


}

