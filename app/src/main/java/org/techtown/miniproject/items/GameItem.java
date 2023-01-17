package org.techtown.miniproject.items;

public class GameItem {

    String game_name;
    String game_event;
    int game_count;

    public GameItem(String game_name, String game_event, int game_count) {
        this.game_name = game_name;
        this.game_event = game_event;
        this.game_count = game_count;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public String getGame_event() {
        return game_event;
    }

    public void setGame_event(String game_event) {
        this.game_event = game_event;
    }

    public int getGame_count() {
        return game_count;
    }

    public void setGame_count(int game_count) {
        this.game_count = game_count;
    }
}
