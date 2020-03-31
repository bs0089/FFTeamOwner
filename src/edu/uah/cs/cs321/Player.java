package edu.uah.cs.cs321;

public class Player {
    private String team, name, position;
    private int points; // This is total points for 2019 season
    private int passesAtt, passesCmp, passingYds, passesInt,  passingTD;
    private int rushesAtt, rushingYds, rushingTD;
    private float rushingYpA;
    private int receivingTgt, receivingRec, receivingYds, receivingTD;
    private float receivingYpA;
    private int fumblesFL, fumblesTD;

    public Player(String playerName, String teamName, String position, int points) {
        team = teamName;
        name = playerName;
        this.position = position;
        this.points = points;
    }

    public void setPassingData(int Cmp, int Att, int Yds, int TD, int Int) {
        passesAtt = Att;
        passesCmp = Cmp;
        passingYds = Yds;
        passesInt = Int;
        passingTD = TD;
    }

    public void setRushingData(int Att, int Yds, float YpA, int TD) {
        rushesAtt = Att;
        rushingYds = Yds;
        rushingYpA = YpA;
        rushingTD = TD;
    }

    public void setReceivingData(int Tgt, int Rec, int Yds, float YpA, int TD) {
        receivingTgt = Tgt;
        receivingRec = Rec;
        receivingYds = Yds;
        receivingTD = TD;
        receivingYpA = YpA;
    }

    public void setFumbleData(int FL, int TD) {
        fumblesFL = FL;
        fumblesTD = TD;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getPosition() {
        return position;
    }
}
