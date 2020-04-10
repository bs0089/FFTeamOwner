package edu.uah.cs.cs321;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Team extends TeamOwner {
    ArrayList<String> players = new ArrayList<String>();
    String teamName = super.GetTeamName();
    Player p;

    public Team(String teamName, ArrayList<String> players) {
        this.players = players;
        this.teamName = teamName;
    }

    public void AddPlayer(Player player) {
        players.add(player.getName());
        players.add(player.getPosition());
        players.add(player.getTeam());
        players.add(player.getPoints());
    }

    public int CombineScore(ArrayList<String> players) {
        return players.get(p.getPoints());
    }
}
