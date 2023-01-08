package org.techtown.miniproject;

public class ScoreItem {

    String match_date;
    String user1_name;
    String user2_name;
    int user1_score;
    int user2_score;

    public ScoreItem(String match_date, String user1_name, String user2_name, int user1_score, int user2_score) {
        this.match_date = match_date;
        this.user1_name = user1_name;
        this.user2_name = user2_name;
        this.user1_score = user1_score;
        this.user2_score = user2_score;
    }

    public String getMatch_date() {
        return match_date;
    }

    public void setMatch_date(String match_date) {
        this.match_date = match_date;
    }

    public String getUser1_name() {
        return user1_name;
    }

    public void setUser1_name(String user1_name) {
        this.user1_name = user1_name;
    }

    public String getUser2_name() {
        return user2_name;
    }

    public void setUser2_name(String user2_name) {
        this.user2_name = user2_name;
    }

    public int getUser1_score() {
        return user1_score;
    }

    public void setUser1_score(int user1_score) {
        this.user1_score = user1_score;
    }

    public int getUser2_score() {
        return user2_score;
    }

    public void setUser2_score(int user2_score) {
        this.user2_score = user2_score;
    }
}