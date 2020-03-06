package com.company;

public class Main {

    public static void main(String[] args) {
	printYearsAndDays(12312415);
	printYearsAndDays(12);
	printYearsAndDays(-124);
    }

    public static void printYearsAndDays(long minutes) {
        String result = "Invalid Value";
        if (minutes >= 0) {
            long days = minutes / 1440;
            long years = days / 365;
            days = days % 365;

            result = minutes + " min = " + years + " y and " + days + " d";
        }
        System.out.println(result);
    }
}
