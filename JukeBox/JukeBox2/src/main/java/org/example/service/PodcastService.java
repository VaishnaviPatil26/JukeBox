package org.example.service;

import org.example.DAOInterface.PodcastInterface;
import org.example.DAOImplmentation.PodcastImpl;
import org.example.model.Podcast;

import java.util.List;
import java.util.Scanner;

public class PodcastService {
    Scanner sc = new Scanner(System.in);
    PodcastInterface podcastInterface = new PodcastImpl();

    public  void podcastMenu(int id){
        while (true) {
            System.out.println("\n---------------------------------------------------------------------");
            System.out.println("*********************** Welcome to Podcast ***************************");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("1. Display All Podcast");
            System.out.println("2. Search Podcast By Podcast Id");
            System.out.println("3. Sort Podcast By Podcast Name");
            System.out.println("4. Play Podcast");
            System.out.println("5. Back to Main Menu");
            System.out.print("\nEnter your Choice : ");
            int choose = sc.nextInt();

            switch (choose) {
                case 1:
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("--------------------------- List of Podcast ----------------------------");
                    System.out.println("podcastId"+"  "+"podcastName"+"        "+"celebrityName"+"  "+"yearOfPodcast");
                    List<Podcast> podcastDetails= podcastInterface.displayAllPodcast();
                    podcastDetails.stream().forEach(x-> System.out.println(x));
                    break;
                case 2:
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("--------------------------- Searched Song ---------------------------");
                    System.out.print("\nEnter the Podcast Id to Search the Podcast : ");
                    String podCastId = sc.next().trim();
                    podcastInterface.searchPodcast(podCastId);
                    break;
                case 3:
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("--------------------- Sorted List (podcastName) ----------------------");
                    System.out.println("podcastId"+"  "+"podcastName"+"         "+"celebrityName"+"  "+"yearOfPodcast");
                    List<Podcast> sortDetails= podcastInterface.sortPodcast();
                    sortDetails.stream().forEach(x-> System.out.println(x));
                    break;
                case 4:
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("--------------------------- Podcast List -----------------------------");
                    System.out.println("podcastId"+"  "+"podcastName"+"       "+"celebrityName"+"  "+"yearOfPodcast");
                    List<Podcast> allPodcast= podcastInterface.displayAllPodcast();
                    allPodcast.stream().forEach(x-> System.out.println(x));
                    System.out.print("\nEnter the Podcast Id: ");
                    String podcastid = sc.next();
                    podcastInterface.playPodcast(podcastid);
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

    public void withoutLoginPodcast(){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("--------------------------- Podcast List -----------------------------");
        System.out.println("podcastId"+"  "+"podcastName"+"       "+"celebrityName"+"  "+"yearOfPodcast");
        List<Podcast> allPodcast= podcastInterface.displayAllPodcast();
        allPodcast.stream().forEach(x-> System.out.println(x));
        System.out.print("\nEnter the Podcast Id: ");
        String podcastid = sc.next();
        podcastInterface.playPodcast(podcastid);
    }
}
