package com.ddu.ce.tournament.service.imp;

import com.ddu.ce.tournament.dao.PlayerDAO;

import com.ddu.ce.tournament.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements com.ddu.ce.tournament.service.PlayerService{

    private PlayerDAO playerDAO;

     @Autowired
     public PlayerServiceImpl(PlayerDAO playerDAO) {
         this.playerDAO = playerDAO;
     }

     public PlayerDAO getPlayerDAO() {
         return playerDAO;
     }

     public void setPlayerDAO(PlayerDAO playerDAO) {
         this.playerDAO = playerDAO;
     }

     public String save(Player player){
            playerDAO.save(player);
            return "Player saved";
     }

     public Player findById(int id) {
         return playerDAO.findById(id).get();
     }

     public String deleteById(int id){

         playerDAO.deleteById(id);
         return "Player deleted";
     }

     public Iterable<Player> findAll() {
         return playerDAO.findAll();
     }

     public String deleteAll(){
         playerDAO.deleteAll();
         return "All players deleted";
     }

}
