package edu.uah.cs.cs321;

public abstract class Player {
    private String team, name;
    private int points;
    private int passesAtt, passesCmp, passingYds, passesInt,  passingTD;
    private int rushesAtt, rushingYds, rushingTD;
    private float rushingYpA;
    private int receivingTgt, receivingRec, receivingYds, receivingTD;
    private float receivingYpA;
    private int fumblesFL, fumblesTD;

    public void setTeam(String teamName) {
        team = teamName;
    }

    public void setName(String playerName) {
        name = playerName;
    }

    public void setPassingData(int Cmp, int Att, int Yds, int Int, int TD) {
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
}
