package model;

public enum Player {
    BLUE("/view/resources/wolfChooser/player_blue.png","/view/resources/wolfChooser/playerLife2_blue.png"),
    GREEN("/view/resources/wolfChooser/player_green.png","/view/resources/wolfChooser/playerLife2_green.png"),
    ORANGE("/view/resources/wolfChooser/player_orange.png","/view/resources/wolfChooser/playerLife2_orange.png"),
    RED("/view/resources/wolfChooser/player_red.png","/view/resources/wolfChooser/playerLife2_red.png");

    String url;
    String url_player_life;

    private Player(String url,String url_player_life) {
        this.url = url;
        this.url_player_life = url_player_life;
    }

    public String getUrl() {
        return url;
    }

    public String getUrl_player_life() {
        return url_player_life;
    }
}
