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
            String name;

            if (!regexMatcher.find()) {
                continue;
            }
            name = regexMatcher.group(1);

            if (playerData.get(3).equals("QB")) {
                Quarterback qb = new Quarterback();

                qb.setName(name);
                qb.setTeam(playerData.get(2));
                qb.setPassingData(Integer.parseInt(playerData.get(7)), Integer.parseInt(playerData.get(8)),
                                  Integer.parseInt(playerData.get(9)), Integer.parseInt(playerData.get(10)),
                                  Integer.parseInt(playerData.get(11)));
                /* Needs error checking for empty strings
                qb.setRushingData(Integer.parseInt(playerData.get(12)), Integer.parseInt(playerData.get(13)),
                                  Float.parseFloat(playerData.get(14)), Integer.parseInt(playerData.get(15)));

                 */
                /* Unnecessary data for Quarterbacks
                qb.setReceivingData(Integer.parseInt(playerData.get(16)), Integer.parseInt(playerData.get(17)),
                                    Integer.parseInt(playerData.get(18)), Float.parseFloat(playerData.get(19)),
                                    Integer.parseInt(playerData.get(20)));
                 */
                qb.setFumbleData(Integer.parseInt(playerData.get(21)), Integer.parseInt(playerData.get(22)));

                players.add(qb);
            } else if (playerData.get(3).equals("RB")) {
                RunningBack rb = new RunningBack();

                rb.setName(name);
                rb.setTeam(playerData.get(2));
                rb.setPassingData(Integer.parseInt(playerData.get(7)), Integer.parseInt(playerData.get(8)),
                                  Integer.parseInt(playerData.get(9)), Integer.parseInt(playerData.get(10)),
                                  Integer.parseInt(playerData.get(11)));
                /* Needs error handling for empty strings
                rb.setRushingData(Integer.parseInt(playerData.get(12)), Integer.parseInt(playerData.get(13)),
                                  Float.parseFloat(playerData.get(14)), Integer.parseInt(playerData.get(15)));
                rb.setReceivingData(Integer.parseInt(playerData.get(16)), Integer.parseInt(playerData.get(17)),
                                    Integer.parseInt(playerData.get(18)), Float.parseFloat(playerData.get(19)),
                                    Integer.parseInt(playerData.get(20)));

                 */
                rb.setFumbleData(Integer.parseInt(playerData.get(21)), Integer.parseInt(playerData.get(22)));

                players.add(rb);
            } else if (playerData.get(3).equals("WR")) {
                WideReceiver wr = new WideReceiver();

                wr.setName(name);
                wr.setTeam(playerData.get(2));
                wr.setPassingData(Integer.parseInt(playerData.get(7)), Integer.parseInt(playerData.get(8)),
                                  Integer.parseInt(playerData.get(9)), Integer.parseInt(playerData.get(10)),
                                  Integer.parseInt(playerData.get(11)));
                /* Unnecessary data for Wide Receiver
                wr.setRushingData(Integer.parseInt(playerData.get(12)), Integer.parseInt(playerData.get(13)),
                                  Float.parseFloat(playerData.get(14)), Integer.parseInt(playerData.get(15)));
                 */
                /* Needs error handling for empty strings
                wr.setReceivingData(Integer.parseInt(playerData.get(16)), Integer.parseInt(playerData.get(17)),
                                    Integer.parseInt(playerData.get(18)), Float.parseFloat(playerData.get(19)),
                                    Integer.parseInt(playerData.get(20)));

                 */
                wr.setFumbleData(Integer.parseInt(playerData.get(21)), Integer.parseInt(playerData.get(22)));

                players.add(wr);
            } else if (playerData.get(3).equals("TE")) {
                TightEnd te = new TightEnd();

                te.setName(name);
                te.setTeam(playerData.get(2));
                te.setPassingData(Integer.parseInt(playerData.get(7)), Integer.parseInt(playerData.get(8)),
                                  Integer.parseInt(playerData.get(9)), Integer.parseInt(playerData.get(10)),
                                  Integer.parseInt(playerData.get(11)));
                /* Unnecessary data for Tight Ends
                te.setRushingData(Integer.parseInt(playerData.get(12)), Integer.parseInt(playerData.get(13)),
                                  Float.parseFloat(playerData.get(14)), Integer.parseInt(playerData.get(15)));
                 */
                te.setReceivingData(Integer.parseInt(playerData.get(16)), Integer.parseInt(playerData.get(17)),
                                    Integer.parseInt(playerData.get(18)), Float.parseFloat(playerData.get(19)),
                                    Integer.parseInt(playerData.get(20)));
                te.setFumbleData(Integer.parseInt(playerData.get(21)), Integer.parseInt(playerData.get(22)));

                players.add(te);
            } else {
                // System.out.println("Invalid player type");
            }
        }
    }
}
