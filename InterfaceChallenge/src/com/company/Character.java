package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Character implements ISaveable {
    private String name;
    private int level;
    private int hitPoints;

    public Character() {
    }

    public Character(String name, int level, int hitPoints) {
        this.name = name;
        this.level = level;
        this.hitPoints = hitPoints;
    }


    @Override
    public List<String> write() {
        List<String> dataList = new ArrayList<String>();
        dataList.addAll(Arrays.asList(this.name, ""+this.level, ""+this.hitPoints));
        return dataList;
    }

    @Override
    public void read(List dataList) {
        this.name = ((List<String>) dataList).get(0);
        this.level = Integer.valueOf(((List<String>) dataList).get(1));
        this.hitPoints = Integer.valueOf(((List<String>) dataList).get(2));
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", hitPoints='" + hitPoints + '\'';
    }
}
