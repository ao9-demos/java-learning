package com.company;

public class Main {

    public static void main(String[] args) {
        BaseballPlayer bell = new BaseballPlayer("Bell");
        PingpongPlayer pat = new PingpongPlayer("Pat");
        FootballPlayer ford = new FootballPlayer("Ford");
        FootballPlayer frank = new FootballPlayer("Frank");

        Team<BaseballPlayer> bTeam = new Team<>("BaseT");
        bTeam.addPlayer(bell);
        System.out.println("bTeam.numPlayers() = " + bTeam.numPlayers());
        Team<PingpongPlayer> pTeam = new Team<>("PingpongT");
        pTeam.addPlayer(pat);
        System.out.println("pTeam.getName() = " + pTeam.getName());

        Team<FootballPlayer> fTeam1 = new Team<>("FootballT1");
        fTeam1.addPlayer(ford);
        Team<FootballPlayer> fTeam2 = new Team<>("FootballT2");
        fTeam2.addPlayer(frank);
        fTeam1.matchScores(fTeam2,3,2);
        fTeam1.matchScores(fTeam2,0,0);
        fTeam1.matchScores(fTeam2, 3,4);
        System.out.println("fTeam1.ranking() = " + fTeam1.ranking());
        System.out.println("fTeam2.ranking() = " + fTeam2.ranking());
    }
}
