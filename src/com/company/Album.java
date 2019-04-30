package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Album {

    private String artist;
    private String albumName;
    private ArrayList<Song> songArrayList;

    public Album(String artist, String albumName) {
        this.artist = artist;
        this.albumName = albumName;
        this.songArrayList = new ArrayList<Song>();
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbumName() {
        return albumName;
    }

    public boolean addSong(String title, double duration){
        if (findSong(title)==null){
            this.songArrayList.add(new Song(title, duration));
            System.out.println(title + " added to album");
            return true;
        }
        return false;
    }

    public Song findSong(String title){
        for (Song checkedSong: this.songArrayList){
            if(checkedSong.getTitle().equals(title)){
                return checkedSong;
            }
        }
        return null;
    }
}
