package com.ddu.ce.tournament.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateMatchScore {
    int matchId;
    int team1Score;
    int team2Score;
    int team1Wickets;
    int team2Wickets;

}
