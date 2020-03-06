package com.company;


public class Main {

    public static void main(String[] args) {
        BasketballTeam worriers = new BasketballTeam("Worriers");
        BasketballTeam lakers = new BasketballTeam("Lakers");
        BasketballTeam heats = new BasketballTeam("Heats");
        FootballTeam realmadrid = new FootballTeam("Real Madrid");

        LeagueTable<BasketballTeam> nba = new LeagueTable<>("NBA");
        nba.addTeam(worriers);
        nba.addTeam(lakers);
        nba.addTeam(heats);

        worriers.matchScores(lakers, 100, 80);
        worriers.matchScores(heats, 110, 80);
        lakers.matchScores(heats, 70,90);

        nba.showRanking();


    }
}
