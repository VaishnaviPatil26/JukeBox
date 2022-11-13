package org.example.service;

import org.example.DAOInterface.PlaylistInterface;
import org.example.DAOImplmentation.PlaylistImpl;
import org.example.model.Playlist;


import java.util.List;
import java.util.Scanner;

public class PlaylistService {
    Scanner sc = new Scanner(System.in);
    PlaylistInterface playlistInterface = new PlaylistImpl();

    public void playlistMenu(int id){
        while (true){
            System.out.println("---------------------------------------------------------------------");
            System.out.println("************************ Welcome to Playlist ************************");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("1. Create New Playlist");
            System.out.println("2. Display  My Playlist");
            System.out.println("3. Delete Playlist");
            System.out.println("4. Search Playlist");
            System.out.println("5. Back to Main Menu");
            System.out.print("\nEnter your Choice : ");
            int choose = sc.nextInt();

            switch (choose){
                case 1:
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("---------------------- Create New Playlist  -------------------------");
                    playlistInterface.createNewPlaylist(id);
                    break;
                case 2:
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("--------------------------- Your Playlist ---------------------------");
                    List<Playlist> playlistsDetails= playlistInterface.displayMyPlaylist(id);
                    playlistsDetails.stream().forEach(x-> System.out.println(x));
                    break;
                case 3:
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("-------------------------- Delete Playlist --------------------------");
                    System.out.print("\nEnter Playlist Id to delete the playlist : ");
                    String listId = sc.next().trim();
                    playlistInterface.deletePlaylist(listId);
                    break;
                case 4:
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("------------------------- Search Playlist ---------------------------");
                    System.out.print("\nEnter the Playlist Id to Search the Playlist : ");
                    String playListId = sc.next().trim();
                    playlistInterface.searchPlaylist(playListId);
                    break;
                case 5:
                    UserService userService = new UserService();
                    userService.menu(id);
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

}
