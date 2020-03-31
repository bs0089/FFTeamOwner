package edu.uah.cs.cs321;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeagueRoster {
    private List<Player> players = new ArrayList<>();

    public LeagueRoster() {
        CSVParser parser;
        Pattern regexPattern = Pattern.compile("(\\w* \\w*)");

        try {
            parser = new CSVParser("FantasyFootballStats2019.csv");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find csv file.");
            return;
        }

        while (parser.hasNextLine()) {
            List<String> playerData = parser.parseLine();
            Matcher regexMatcher = regexPattern.matcher(playerData.get(1));
            Player player;
            String name;

            // If csv entry has no valid name, move to next entry
            if (!regexMatcher.find()) {
                continue;
            }
            name = regexMatcher.group(1);

            if (playerData.get(26).isEmpty()) {
                player = new Player(name, playerData.get(2), playerData.get(3), 0);
            } else {
                player = new Player(name, playerData.get(2), playerData.get(3), Integer.parseInt(playerData.get(26)));
            }

            player.setPassingData(Integer.parseInt(playerData.get(7)), Integer.parseInt(playerData.get(8)),
                    Integer.parseInt(playerData.get(9)), Integer.parseInt(playerData.get(10)),
                    Integer.parseInt(playerData.get(11)));

            if (playerData.get(14).isEmpty()) {
                player.setRushingData(Integer.parseInt(playerData.get(12)), Integer.parseInt(playerData.get(13)),
                                      (float) 0.0, Integer.parseInt(playerData.get(15)));
            } else {
                player.setRushingData(Integer.parseInt(playerData.get(12)), Integer.parseInt(playerData.get(13)),
                                      Float.parseFloat(playerData.get(14)), Integer.parseInt(playerData.get(15)));
            }

            if (playerData.get(19).isEmpty()) {
                player.setReceivingData(Integer.parseInt(playerData.get(16)), Integer.parseInt(playerData.get(17)),
                                        Integer.parseInt(playerData.get(18)), (float) 0.0,
                                        Integer.parseInt(playerData.get(20)));
            } else {
                player.setReceivingData(Integer.parseInt(playerData.get(16)), Integer.parseInt(playerData.get(17)),
                                        Integer.parseInt(playerData.get(18)), Float.parseFloat(playerData.get(19)),
                                        Integer.parseInt(playerData.get(20)));
            }

            player.setFumbleData(Integer.parseInt(playerData.get(21)), Integer.parseInt(playerData.get(22)));

            players.add(player);
        }
    }
}
