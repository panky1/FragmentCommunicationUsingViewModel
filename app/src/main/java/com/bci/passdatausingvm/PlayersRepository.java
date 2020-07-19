package com.bci.passdatausingvm;

import java.util.HashMap;

public class PlayersRepository {
    private String players[];
    private HashMap<String, Player> playerDetails;
    public String[] getPlayers(){
        if(players == null){
            players = new String[7];
            players[0] = "Rafael Nadal";
            players[1] = "Roger Federer";
            players[2] = "Juan Martin del Potro";
            players[3] = "Alexander Zverev";
            players[4] = "Grigor Dimitrov";
            players[5] = "Kevin Anderson";
            players[6] = "Marin Cilic";
        }

        return players;
    }

    public Player getPlayerDetails(String name){
        if(playerDetails == null){
            createPlayerDetailsMap();
        }
        return playerDetails.get(name);
    }

    public void createPlayerDetailsMap(){
        playerDetails = new HashMap<String, Player>();

        Player player = new Player();
        player.setName("Rafael Nadal");
        player.setAge(32);
        player.setCountry("Spain");
        player.setRank(1);
        player.setTitles(80);

        playerDetails.put("Rafael Nadal", player);

        player = new Player();
        player.setName("Roger Federer");
        player.setAge(37);
        player.setCountry("Switzerland");
        player.setRank(2);
        player.setTitles(98);

        playerDetails.put("Roger Federer", player);


        player = new Player();
        player.setName("Juan Martin del Potro");
        player.setAge(29);
        player.setCountry("Argentina");
        player.setRank(3);
        player.setTitles(22);

        playerDetails.put("Juan Martin del Potro", player);

        player = new Player();
        player.setName("Alexander Zverev");
        player.setAge(21);
        player.setCountry("Germany");
        player.setRank(4);
        player.setTitles(9);

        playerDetails.put("Alexander Zverev", player);

        player = new Player();
        player.setName("Grigor Dimitrov");
        player.setAge(27);
        player.setCountry("Bulgaria");
        player.setRank(5);
        player.setTitles(8);

        playerDetails.put("Grigor Dimitrov", player);

        player = new Player();
        player.setName("Kevin Anderson");
        player.setAge(32);
        player.setCountry("South Africa");
        player.setRank(6);
        player.setTitles(4);

        playerDetails.put("Kevin Anderson", player);

        player = new Player();
        player.setName("Marin Cilic");
        player.setAge(32);
        player.setCountry("Italy");
        player.setRank(6);
        player.setTitles(4);

        playerDetails.put("Marin Cilic", player);
    }
}