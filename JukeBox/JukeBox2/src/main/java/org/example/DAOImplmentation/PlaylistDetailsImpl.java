package org.example.DAOImplmentation;

import org.example.DBConnection;
import org.example.DAOInterface.PlaylistDetailsInterface;
import org.example.model.Playlist;
import org.example.service.UserService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class PlaylistDetailsImpl implements PlaylistDetailsInterface {
    Scanner sc = new Scanner(System.in);
    Playlist playlist = new Playlist();

    @Override
    public void displayMyPlaylistDetails(int uid) {
        UserService userService = new UserService();
        try {
            while (true){
                System.out.println("\n1. Playlistdetails");
                System.out.println("2. Back to main menu");
                System.out.println("3. Exit");
                System.out.print("Enter your Choice : ");
                int choice = sc.nextInt();
                switch (choice){
                    case 1:
                        Connection con= DBConnection.getConnection();
                        String query1="select * from Playlist where userId ='"+uid+"'";
                        Statement st1= con.createStatement();
                        ResultSet rs1=st1.executeQuery(query1);
                        System.out.println("\npodcastId"+"       "+"podcastName");
                        while(rs1.next()){
                            String id =  rs1.getString("playlistId");
                            String pName = rs1.getString("playlistName");
                            System.out.println(" "+id+"          "+pName+"\n");
                        }
                        System.out.println("--------------------------------------------------------------");
                        System.out.print("Enter playlist Id : ");
                        String plId = sc.next().trim();
                        System.out.println("--------------------------------------------------------------");
                        String query="select * from PlaylistDetails where playlistId ='"+plId+"'";
                        Statement st= con.createStatement();
                        ResultSet rs=st.executeQuery(query);
                        System.out.println("\nPlaylist Id"+"  "+"Playlist Name"+"  SongIdOrpodcastId");
                        while(rs.next()){
                            String id =  rs.getString("playlistDetailsId");
                            String pName = rs.getString("playlistId");
                            String sIdorpId = rs.getString("songIdOrpodcastId");
                            System.out.println(" "+id+"          "+pName+"            "+sIdorpId+"\n");
                        }
                        System.out.println("-----------------------------------------------------------------");
                        break;
                    case 2:
                        userService.menu(uid);
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        }catch (Exception e){
            System.out.println("Error--"+e);
        }
    }
}
