package com.company;

public class Main {
    private static final String INVALID_VALUE_MESSAGE = "Invalid value";

    public static void main(String[] args) {
        System.out.println(getDurationString(467,46));
        System.out.println(getDurationString(123124));
        System.out.println(getDurationString(15));
        System.out.println(getDurationString(3600));
        System.out.println(getDurationString(-1230));
    }

    public static String getDurationString(int minutes, int seconds) {
        String result = INVALID_VALUE_MESSAGE;
        if (minutes >= 0 && seconds >= 0 && seconds <= 59) {
            int hours = minutes / 60;
            minutes = minutes % 60;

            String hoursString = hours + "h ";
            if (hours < 10) {
                hoursString = "0" + hoursString;
            }

            String minutesString = minutes + "m ";
            if(minutes < 10) {
                minutesString = "0" + minutesString;
            }

            String secondsString = seconds + "s";
            if(seconds < 10) {
                secondsString = "0" + secondsString;
            }

            result = hoursString + minutesString  + secondsString;
        }
        return result;
    }

    public static String getDurationString(int seconds) {
        String result = INVALID_VALUE_MESSAGE;
        if(seconds >= 0) {
            int minutes = seconds / 60;
            seconds = seconds % 60;
            result = getDurationString(minutes, seconds);
        }
        return result;
    }
}
