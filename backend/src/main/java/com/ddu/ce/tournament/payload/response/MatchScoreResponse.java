package com.ddu.ce.tournament.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MatchScoreResponse {

    private int match_id ;
    private String team1;
    private String team2 ;

    private int team1_score;
    private int team2_score;
    private int team1_wickets;
    private int team2_wickets;


}
