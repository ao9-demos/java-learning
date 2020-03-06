package com.company;

public class Main {

    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 10000;
        int levelCompleted = 8;
        int bonus = 200;

        checkAndPrint(gameOver, score, levelCompleted, bonus);
        int finalScore = caculate(true, 800, 5, 100);
        System.out.println("finalScore = " + finalScore);

        displayHighScorePosition("Adam",caculateHighScorePosition(1500));
        displayHighScorePosition("Bobby",caculateHighScorePosition(900));
        displayHighScorePosition("Cathy",caculateHighScorePosition(400));
        displayHighScorePosition("Dug",caculateHighScorePosition(50));

    }

    public static void checkAndPrint(boolean gameOver, int score, int levelCompleted, int bonus) {
        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            System.out.println("finalScore = " + finalScore);
        }
    }

    public static int caculate(boolean gameOver, int score, int levelCompleted, int bonus) {

        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            return finalScore;
        }
        return -1;
    }

    public static void displayHighScorePosition(String playerName, int position) {
        System.out.println(playerName + " managed to get into position " + position + " on the high score table.");
    }

    public static int caculateHighScorePosition(int playerScore) {
        int position = 4;
        if(playerScore > 1000) {
            position = 1;
        } else if (playerScore > 500) {
            position = 2;
        } else if (playerScore > 100) {
            position = 3;
        }
        return position;
    }
}
