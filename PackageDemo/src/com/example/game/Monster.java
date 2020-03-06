package com.example.game;

import java.util.Arrays;
import java.util.List;

public class Monster extends Character{
    private String power;
    private String reward;

    public Monster() {
    }

    public Monster(String name, int level, int hitPoints, String power, String reward) {
        super(name, level, hitPoints);
        this.power = power;
        this.reward = reward;
    }

    @Override
    public List<String> write() {
        List<String> dataList = super.write();;
        dataList.addAll(Arrays.asList(power, reward));
        return dataList;
    }

    @Override
    public void read(List dataList) {
        if (dataList != null && dataList.size() > 0) {
            super.read(dataList);
            power = ((List<String>) dataList).get(3);
            reward = ((List<String>) dataList).get(4);
        }
    }

    @Override
    public String toString() {
        return "Monster{" +
                super.toString() +
                ", power='" + power + '\'' +
                ", reward='" + reward + '\'' +
                '}';
    }
}
