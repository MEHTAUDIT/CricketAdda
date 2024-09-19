package com.ddu.ce.tournament.payload.request;

import com.ddu.ce.tournament.entity.Team;
import com.ddu.ce.tournament.entity.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TournamentRequest {
    private String tournament_name;
    private String tournament_type;

    private List<Team> teams;

    private String start_date;

    private String owner_email;

}
