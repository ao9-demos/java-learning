package com.company.todolist;

import java.time.LocalDate;

public class TestMain {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2019, 8, 15);

        LocalDate date2 = null;

        System.out.println(date1.compareTo(date2));
    }
}
