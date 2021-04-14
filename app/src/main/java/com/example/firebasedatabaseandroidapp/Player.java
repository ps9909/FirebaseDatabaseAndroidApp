package com.example.firebasedatabaseandroidapp;

public class Player {
    private String playerName;
    private String playerGame;
    private String playerCountry;
    private String playerId;

    public Player( ) {

    }

    public Player(String playerName, String playerGame, String playerCountry, String playerId) {
        this.playerName = playerName;
        this.playerGame = playerGame;
        this.playerCountry = playerCountry;
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerGame() {
        return playerGame;
    }

    public String getPlayerCountry() {
        return playerCountry;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerGame(String playerGame) {
        this.playerGame = playerGame;
    }

    public void setPlayerCountry(String playerCountry) {
        this.playerCountry = playerCountry;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }
}
