package com.company;

public abstract class Team implements Comparable<Team>{
    private String name;
    private int played;
    private int won;
    private int lost;
    private int tied;

    public Team(String name) {
        this.name = name;
    }

    public void matchScores(Team opponent, int ourScore, int theirScore){
        String message;
        if (ourScore > theirScore) {
            message = " won ";
            won++;
        } else if (ourScore < theirScore) {
            message = " lost to ";
            lost++;
        } else {
            message = " tied with ";
            tied++;
        }
        played++;
        if (opponent != null) {
            System.out.println(this.name + message + opponent.getName());
            opponent.matchScores(null,theirScore,ourScore);
        }
    }

    public int ranking(){
        return (won * 3) + tied;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Team team) {
        if (this.ranking() < team.ranking()) {
            return -1;
        } else if (this.ranking() > team.ranking()) {
            return 1;
        } else {
            return 0;
        }
    }
}
