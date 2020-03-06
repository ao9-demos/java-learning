package com.company;

import java.util.Arrays;
import java.util.List;

public class Player extends Character {
    private String magic;
    private String weapon;

    public Player() {
    }

    public Player(String name, int level, int hitPoints, String magic, String weapon) {
        super(name, level, hitPoints);
        this.magic = magic;
        this.weapon = weapon;
    }

    @Override
    public List<String> write() {
        List<String> dataList = super.write();
        dataList.addAll(Arrays.asList(this.magic, this.weapon));
        return dataList;
    }

    @Override
    public void read(List dataList) {
        if (dataList != null && dataList.size() > 0) {
            super.read(dataList);
            this.magic = ((List<String>) dataList).get(3);
            this.weapon = ((List<String>) dataList).get(4);
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                super.toString() +
                ", magic='" + magic + '\'' +
                ", weapon='" + weapon + '\'' +
                '}';
    }
}
