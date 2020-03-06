package com.company;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static SongCollections mySongCollections = new SongCollections();
    private static LinkedList<Song> playList = new LinkedList<Song>();
    private static ListIterator<Song> songListIterator;
    private static boolean playingForward ;

    public static void main(String[] args) {
        printInstructions();
        boolean quit = false;
        int choice = 0;
        while (!quit) {
            try {
                choice = scanner.nextInt();

            } catch (Exception e) {
                e.printStackTrace();
            }
            scanner.nextLine();
            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    addAlbum();
                    break;
                case 2:
                    addSong();
                    break;
                case 3:
                    addToPlaylist();
                    break;
                case 4:
                    removeFromPlaylist();
                    break;
                case 5:
                    startPlayer();
                    break;
                case 9:
                    quit = true;
                    break;
            }
        }

    }

    private static void printInstructions() {
        System.out.println("0. instructions");
        System.out.println("1. add an album");
        System.out.println("2. add an song");
        System.out.println("3. add an song to playlist");
        System.out.println("4. remove an song from playlist");
        System.out.println("5. start player");
        System.out.println("9. quit");

    }

    private static void addAlbum() {
        System.out.println("Input - album title");
        String albumTitle = scanner.nextLine();
        int albumPosition = mySongCollections.findAlbum(albumTitle);
        if (albumPosition >= 0) {
            System.out.println("Error: album already exists");
        } else {
            Album newAlbum = new Album(albumTitle);
            mySongCollections.addAlbum(newAlbum);
            System.out.println("Added " + albumTitle);
        }
    }

    private static void addSong() {
        System.out.println("Input - add to which album");
        String albumTitle = scanner.nextLine();
        int albumPosition = mySongCollections.findAlbum(albumTitle);
        if (albumPosition < 0) {
            System.out.println("Error: album doesn't exist");
        } else {
            System.out.println("Input - song title");
            String songTitle = scanner.nextLine();
            Song foundSong = mySongCollections.findSong(songTitle);

            if (foundSong != null) {
                System.out.println("Error: song already exists");
            } else {
                int duration = 0;
                System.out.println("Input - seconds of song duration");
                try {

                    duration = scanner.nextInt();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                scanner.nextLine();

                Song newSong = new Song(songTitle, duration);
                mySongCollections.addSong(albumPosition, newSong);
                System.out.println("Added " + songTitle + " at " + mySongCollections.getAlbumTitle(albumPosition));
            }
        }
    }

    private static void addToPlaylist() {
        System.out.println("Input - which song to add");
        String songTitle = scanner.nextLine();
        int songPosition = findSongInPlaylist(songTitle);
        if (songPosition >= 0) {
            System.out.println("Error: song already exist in playlist");
        } else {
            Song foundSong = mySongCollections.findSong(songTitle);
            if (foundSong == null) {
                System.out.println("Error: song doesn't exist");
            } else {
                playList.add(foundSong);
                System.out.println("Added " + songTitle + " to playlist");
                printTotalDuration();
            }
        }

    }

    private static void removeFromPlaylist() {
        System.out.println("Input - which song to remove");
        String songTitle = scanner.nextLine();
        int songPosition = findSongInPlaylist(songTitle);

        if (songPosition < 0) {
            System.out.println("Error: song isn't in playlist");
        } else {
            playList.remove(songPosition);
            System.out.println("Removed " + songTitle + " from playlist");
        }
    }

    private static int findSongInPlaylist(String songTitle) {
        for (int i = 0; i < playList.size(); i++) {
            if (playList.get(i).getSongTitle().equals(songTitle)) {
                return i;
            }
        }
        return -1;
    }

    private static void startPlayer() {

        System.out.println("----Player started----");
        printPlayerInstructions();

        songListIterator = playList.listIterator();
        playingForward = true;
        boolean quit = false;
        int choice = 0;
        while (!quit) {
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                e.printStackTrace();
            }
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printPlayerInstructions();
                    break;
                case 1:
                    playNext();
                    break;
                case 2:
                    playPrevious();
                    break;
                case 3:
                    replay();
                    break;
                case 4:
                    printTotalDuration();
                    break;
                case 5:
                    printPlaylist();
                    break;

                case 9:
                    quit = true;
                    System.out.println("----Player quit----");
                    printInstructions();
                    break;
            }
        }
    }

    private static void printPlayerInstructions() {
        System.out.println("0. instructions");
        System.out.println("1. play next song");
        System.out.println("2. play previous song");
        System.out.println("3. replay");
        System.out.println("4. total duration");
        System.out.println("5. print playlist");
        System.out.println("9. quit");

    }

    private static void playNext() {
        if (!playingForward && songListIterator.hasNext()) {
            songListIterator.next();
            playingForward = true;
        }
        if (songListIterator.hasNext()) {
            System.out.println("Playing " + songListIterator.next().getSongTitle());
        } else {
            System.out.println("No next song");
        }
    }

    private static void playPrevious() {
        if (playingForward && songListIterator.hasPrevious()) {
            songListIterator.previous();
            playingForward = false;
        }
        if (songListIterator.hasPrevious()) {
            System.out.println("Playing " + songListIterator.previous().getSongTitle());
        } else {
            System.out.println("No previous song");
        }

    }

    private static void replay() {
        if (playingForward && songListIterator.hasPrevious()) {
            songListIterator.previous();
            System.out.println("Replaying " + songListIterator.next().getSongTitle());
        } else if (!playingForward && songListIterator.hasNext()) {
            songListIterator.next();
            System.out.println("Replaying " + songListIterator.previous().getSongTitle());
        } else if(playingForward && !songListIterator.hasPrevious()){
            System.out.println("Error: hasn't played yet");
        }


    }

    private static void printTotalDuration() {
        int totalDuration = 0;
        for (int i = 0; i < playList.size(); i++) {
            totalDuration += playList.get(i).getDuration();
        }
        int minute = totalDuration / 60;
        int second = totalDuration % 60;
        System.out.println("Total duration is " + minute + "'" + second + "''");

    }

    private static void printPlaylist() {
        ListIterator<Song> songListIterator = playList.listIterator();
        int number = 1;
        while (songListIterator.hasNext()) {
            System.out.println(number + ". " + songListIterator.next().getSongTitle());
            number++;
        }
        printTotalDuration();
    }
}
