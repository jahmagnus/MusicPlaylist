package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

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

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            this.songArrayList.add(new Song(title, duration));
           // System.out.println(title + " added to album");
            return true;
        }
        return false;
    }

    public Song findSong(String title) {
        for (Song checkedSong : this.songArrayList) {
            if (checkedSong.getTitle().equals(title)) {
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber -1;
        if ((index >=0) && (index <= this.songArrayList.size())) {
            playlist.add(this.songArrayList.get(index));
          //  System.out.println(this.songArrayList.get(index).getTitle() + " added to playlist");
            return true;
        }
        //System.out.println("This album does not have track number " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        Song checkedSong = findSong(title);
        if (checkedSong != null) {
            playlist.add(checkedSong);
           // System.out.println(checkedSong + " added to playlist");
            return true;
        }
        System.out.println(title + " not found");
        return false;
    }


    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
}
