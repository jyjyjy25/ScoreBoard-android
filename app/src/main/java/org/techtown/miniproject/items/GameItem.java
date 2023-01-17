package org.techtown.miniproject.items;

public class GameItem {

    String game_name;
    int game_count;

    public GameItem(String game_name, int game_count) {
        this.game_name = game_name;
        this.game_count = game_count;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public int getGame_count() {
        return game_count;
    }

    public void setGame_count(int game_count) {
        this.game_count = game_count;
    }
}
