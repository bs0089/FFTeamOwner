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
        this.team = teamName;
        this.name = playerName;
        this.position = position;
        this.points = points;
    }

    public void setPassingData(int Cmp, int Att, int Yds, int TD, int Int) {
        this.passesAtt = Att;
        this.passesCmp = Cmp;
        this.passingYds = Yds;
        this.passesInt = Int;
        this.passingTD = TD;
    }

    public void setRushingData(int Att, int Yds, float YpA, int TD) {
        this.rushesAtt = Att;
        this.rushingYds = Yds;
        this.rushingYpA = YpA;
        this.rushingTD = TD;
    }

    public void setReceivingData(int Tgt, int Rec, int Yds, float YpA, int TD) {
        this.receivingTgt = Tgt;
        this.receivingRec = Rec;
        this.receivingYds = Yds;
        this.receivingTD = TD;
        this.receivingYpA = YpA;
    }

    public void setFumbleData(int FL, int TD) {
        this.fumblesFL = FL;
        this.fumblesTD = TD;
    }

    public String getName() {
        return this.name;
    }

    public String getTeam() {
        return this.team;
    }

    public String getPosition() {
        return this.position;
    }

    public int getPoints() {
        return points;
    }
}
