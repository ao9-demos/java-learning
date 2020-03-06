package com.company;

import java.util.ArrayList;

public class Album {
    private String albumTitle;
    private ArrayList<Song> songList;

    public Album(String albumTitle) {
        this.albumTitle = albumTitle;
        this.songList = new ArrayList<Song>();
    }

    public boolean addSong(Song newSong){
        songList.add(newSong);
        return true;
    }

    public Song findSong(String songTitle){
        for(Song checkSong : this.songList){
            if(checkSong.getSongTitle().equals(songTitle)){
                return checkSong;
            }
        }
        return null;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }
}
