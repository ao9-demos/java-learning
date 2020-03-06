package com.company;

import java.util.ArrayList;

public class SongCollections {
    private ArrayList<Album> albumList = new ArrayList<Album>();

    public boolean addAlbum(Album newAlbum){
        albumList.add(newAlbum);
        return true;
    }

    public boolean addSong(int albumPosition, Song newSong){
        albumList.get(albumPosition).addSong(newSong);
        return true;
    }

    public int findAlbum(String albumTitle){
        for(int i=0; i<albumList.size(); i++){
            if(albumList.get(i).getAlbumTitle().equals(albumTitle)){
                return i;
            }
        }
        return -1;
    }

    public Song findSong(String songTitle){
        Song foundSong;
        for(Album checkAlbum : this.albumList){
            foundSong = checkAlbum.findSong(songTitle);
            if(foundSong != null){
                return foundSong;
            }
        }
        return null;
    }

    public String getAlbumTitle(int albumPosition){
       return albumList.get(albumPosition).getAlbumTitle();
    }
}
