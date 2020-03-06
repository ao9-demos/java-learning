package com.company;

import java.util.ArrayList;

public class Album {
    private String albumTitle;
    private SongList songList;

    public Album(String albumTitle) {
        this.albumTitle = albumTitle;
        this.songList = new SongList();
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public boolean addSong(Song newSong){
        return songList.addSong(newSong);

    }

    public Song findSong(String songTitle){
        return songList.findSong(songTitle);
    }

    class SongList {
        private ArrayList<Song> songList;

        public SongList() {
            this.songList = new ArrayList<Song>();
        }

        private boolean addSong(Song newSong){
            songList.add(newSong);
            return true;
        }

        private Song findSong(String songTitle){
            for(Song checkSong : this.songList){
                if(checkSong.getSongTitle().equals(songTitle)){
                    return checkSong;
                }
            }
            return null;
        }
    }

}
