package com.stanzione.profileprototype;

/**
 * Created by lstanzione on 2/15/2016.
 */
public class Friend {

    public enum FriendStatus {
        STATUS_OFFLINE,
        STATUS_ONLINE
    }

    private String name;
    private int games;
    private int wins;
    private int losses;
    private FriendStatus status;
    private boolean favorite;

    public Friend(String name, int games, int wins, int losses, FriendStatus status, boolean favorite){
        setName(name);
        setGames(games);
        setWins(wins);
        setLosses(losses);
        setStatus(status);
        setFavorite(favorite);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public FriendStatus getStatus() {
        return status;
    }

    public void setStatus(FriendStatus status) {
        this.status = status;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getGamesStatus(){
        return "Games: " + getGames() + " / Wins: " + getWins() + " / Losses: " + getLosses();
    }

}
