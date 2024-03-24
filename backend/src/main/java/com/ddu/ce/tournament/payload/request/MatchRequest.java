package com.ddu.ce.tournament.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MatchRequest {

    private int team1_id;
    private int team2_id;
    private int tournament_id;
    private Date match_date;


}
