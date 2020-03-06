package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class LeagueTable<T extends Team> {
    private String name;
    private ArrayList<T> teamList;

    public LeagueTable(String name) {
        this.name = name;
        this.teamList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean addTeam(T newTeam) {
        if (teamList.contains(newTeam)) {
            System.out.println(newTeam.getName() + " already exists");
            return false;
        } else {
            teamList.add(newTeam);
            return true;
        }
    }

    public void showRanking() {
        Collections.sort(teamList, Collections.reverseOrder());
        System.out.println("============");
        System.out.println("Lead board");
        for(int i=0; i<teamList.size(); i++) {
            System.out.println((i+1) + ". " + teamList.get(i).getName() + " " + teamList.get(i).ranking());
        }
    }
}
