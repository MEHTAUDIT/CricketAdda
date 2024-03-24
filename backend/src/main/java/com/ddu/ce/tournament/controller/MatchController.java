package com.ddu.ce.tournament.controller;

import com.ddu.ce.tournament.entity.Match;
import com.ddu.ce.tournament.service.MatchService;
import com.ddu.ce.tournament.service.imp.MatchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*"  )
public class MatchController {

    @Autowired
    private MatchServiceImpl matchService;

    @GetMapping("")
    public String home() {
        return "Welcome to the Tournament API , please use the following endpoints: /player, /team, /match, /tournament";
    }

   @PostMapping("/match")
   @PreAuthorize("hasRole('ADMIN')")
    public void createMatch(@RequestBody Match match) {
        System.out.println("MatchController.createMatch");
        matchService.save(match);
    }

    @GetMapping("/match/{id}")
    public Match findMatch(@PathVariable int id) {
        System.out.println("MatchController.findMatch");
        return matchService.findById(id);
    }


    @DeleteMapping("/match/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteMatch(@PathVariable int id) {
        System.out.println("MatchController.deleteMatch");
        matchService.deleteById(id);
    }

    @GetMapping("/matches")
    public Iterable<Match> findAllMatches() {
        System.out.println("MatchController.findAllMatches");
        return matchService.findAll();
    }

    @PutMapping("/match")
    @PreAuthorize("hasRole('ADMIN')")
    public void updateMatch(@RequestBody Match match) {
        System.out.println("MatchController.updateMatch");
        matchService.save(match);
    }




}
