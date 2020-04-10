package edu.uah.cs.cs321;

public class TeamOwner {
    String ownerName;
    String teamName;
    int draftPos;
    float record;

    public TeamOwner(String ownerName, String teamName, int draftPos, float record) {
        this.ownerName = ownerName;
        this.teamName = teamName;
        this.draftPos = draftPos;
        this.record = record;
    }

    String GetOwnerName() {
        return this.ownerName;
    }

    String GetTeamName() {
        return this.teamName;
    }

    int GetDraftPos() {
        return this.draftPos;
    }

    float GetRecord() {
        return this.record;
    }
}
