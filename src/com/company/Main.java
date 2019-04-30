package com.company;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private static ArrayList<Album> album = new ArrayList<Album>();
    private static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

        Album chindog = new Album("Chindogs", "Chin Parade");
        chindog.addSong("The way", 3.04);
        chindog.addSong("Septic Tank", 3.04);
        chindog.addSong("Hawk", 3.04);
        chindog.addSong("Jaws", 3.04);
        chindog.addSong("Pin Cushion", 3.04);
        chindog.addSong("Theo", 3.04);
        album.add(chindog);

        Album shepdog = new Album("ShepDog", "shep Parade");
        shepdog.addSong("Pen", 4.05);
        shepdog.addSong("Texta", 4.05);
        shepdog.addSong("Hat", 4.05);
        shepdog.addSong("Mug", 4.05);
        shepdog.addSong("Calculator", 4.05);
        shepdog.addSong("Pencil", 4.05);
        shepdog.addSong("Book", 4.05);
        album.add(shepdog);

        Album mouse = new Album("Mouse", "Mouse Parade");
        mouse.addSong("Map", 4.05);
        mouse.addSong("Flag", 4.05);
        mouse.addSong("Data", 4.05);
        mouse.addSong("Math", 4.05);
        mouse.addSong("Mouse", 4.05);
        album.add(mouse);

        LinkedList<Song> playlist = new LinkedList<Song>();
        album.get(0).addToPlayList(1, playlist);
        album.get(1).addToPlayList(2, playlist);
        album.get(2).addToPlayList(3, playlist);

        album.get(0).addToPlayList("Jaws", playlist);

        play(playlist);


    }

    private static void play(LinkedList playlist) {

        ListIterator<Song> songListIterator = playlist.listIterator();
        boolean quit = false;
        boolean goingForward = true;

        if (playlist.isEmpty()){
            System.out.println("Playlist is empty");
        } else {
            System.out.println("Playing >" + "'" +songListIterator.next()+"'");

        }

        while (!quit) {
            printMenu();
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    if (!goingForward){
                        if (songListIterator.hasNext()){
                            songListIterator.next();
                        }
                        goingForward =true;
                    }
                    if (songListIterator.hasNext()){
                        System.out.println("Playing: " + songListIterator.next());
                    } else{
                        System.out.println("End of playlist");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward){
                        if (songListIterator.hasPrevious()){
                            songListIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (songListIterator.hasPrevious()){
                        System.out.println("Playing: " + songListIterator.previous());
                    } else {
                        System.out.println("Start of list");
                        goingForward = true;
                    }
                    break;
            }


        }
    }

    private static void printMenu(){
        System.out.println("0 - close music player\n" +
                "1 - next song\n" +
                "2 - previous song");

    }
}