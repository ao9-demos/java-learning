package com.company;

import java.util.ArrayList;

public class Team<T extends Player> {
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;
private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player){
        if(members.contains(player)){
            System.out.println(player.getName()  + " is already in the team");
            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + " is added into " + this.name);
            return true;
        }
    }

    public int numPlayers(){
        return this.members.size();
    }

    public void matchScores(Team<T> opponent, int ourScore, int theirScore){
        String message;
        if (ourScore > theirScore) {
            this.won += 1;
            message = " won ";
        } else if (ourScore < theirScore) {
            this.lost += 1;
            message = " lost to ";
        } else {
            this.tied += 1;
            message = " tied with ";
        }
        played += 1;
        if (opponent != null) {
            System.out.println(this.name + message + opponent.getName());
            opponent.matchScores(null,theirScore,ourScore);
        }
    }

    public int ranking(){
        return (won * 2) + tied;
    }
}
