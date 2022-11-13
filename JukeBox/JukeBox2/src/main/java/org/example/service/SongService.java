package org.example.service;

import org.example.DAOInterface.SongInterface;
import org.example.DAOImplmentation.SongsImpl;
import org.example.model.Songs;

import java.util.List;
import java.util.Scanner;

public class SongService {

    Scanner sc = new Scanner(System.in);
    SongInterface songInterface = new SongsImpl();

    public  void songMenu(int userId){
        while (true) {
            System.out.println("\n---------------------------------------------------------------------");
            System.out.println("************************ Welcome to Songs ***************************");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("1. Display All Songs");
            System.out.println("2. Search Song By songId");
            System.out.println("3. Sort Song By Name");
            System.out.println("4. Play Songs");
            System.out.println("5. Back to Main Menu");
            System.out.print("\nEnter Your Choice :");
            int choose = sc.nextInt();

            switch (choose) {
                case 1:
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("--------------------------- List of Songs ----------------------------");
                    System.out.println("songId\t"+"songName\t\t\t"+"artistName\t\t"+"genre"+ "\t\t\t\tduration");
                    List<Songs> songDetails= songInterface.displayAllSongs();
                    songDetails.stream().forEach(x-> System.out.println(x));
                    break;
                case 2:
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("Enter the Song Id To Search the Song : ");
                    String id = sc.next().trim();
                    songInterface.searchSong(id);
                    break;
                case 3:
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("--------------------------- Sorted List -----------------------------");
                    System.out.println("songId\t"+"songName\t"+"artistName\t\t"+"genre"+ "\t\t\tduration");
                    List<Songs> list = songInterface.sortSong();
                    list.stream().forEach(x-> System.out.println(x));
                    break;
                case 4:
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("--------------------------- Song List -----------------------------");
                    System.out.println("songId\t"+"songName\t\t"+"artistName\t\t"+"genre"+ "\t\t\tduration");
                    List<Songs> allSong= songInterface.displayAllSongs();
                    allSong.stream().forEach(x-> System.out.println(x));
                    System.out.print("\nPlay the song by Song Id: ");
                    String songId = sc.next().trim();
                    songInterface.playSongs(songId);
                    break;
                case 5:
                    UserService userService = new UserService();
                    userService.menu(userId);
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    public void withoutLoginMenu(){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("--------------------------- Song List -----------------------------");
        System.out.println("songId\t"+"songName\t"+"artistName\t\t"+"genre"+ "\t\t\tduration");
        List<Songs> allSong= songInterface.displayAllSongs();
        allSong.stream().forEach(x-> System.out.println(x));
        System.out.print("\nPlay the song by Song Id: ");
        String songId = sc.next().trim();
        songInterface.playSongs(songId);
    }
}
