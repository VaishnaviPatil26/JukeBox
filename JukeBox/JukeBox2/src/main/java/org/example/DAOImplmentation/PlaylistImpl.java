package org.example.DAOImplmentation;

import org.example.DBConnection;
import org.example.DAOInterface.PlaylistInterface;
import org.example.model.Playlist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlaylistImpl implements PlaylistInterface {

    Scanner sc = new Scanner(System.in);
    Playlist playlist = new Playlist();

    @Override
    public void createNewPlaylist(int id) {
        try {
            Connection con = DBConnection.getConnection();
            System.out.print("Enter Playlist Id (Should start with L): ");
            String pId = sc.next().trim();
            playlist.setPlaylistId(pId);
            System.out.print("Enter Playlist Name : ");
            String pName = sc.next().trim();
            playlist.setPlaylistName(pName);

            String custQuery = "insert into Playlist values('" + playlist.getPlaylistId() + "','" + playlist.getPlaylistName() + "','"+id+"')";
            Statement statement = con.createStatement();
            int rows = statement.executeUpdate(custQuery);
            System.out.println("Playlist Created Successfully");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public List<Playlist> displayMyPlaylist(int userId) {
        List<Playlist> playlist = new ArrayList<>();
        try {
            Connection con= DBConnection.getConnection();
            String query="select * from Playlist where userId ='"+userId+"'";
            Statement st= con.createStatement();
            ResultSet rs=st.executeQuery(query);
            System.out.println("\npodcastId"+"       "+"podcastName");
            while(rs.next()){
                String id =  rs.getString("playlistId");
                String pName = rs.getString("playlistName");
                System.out.println(" "+id+"          "+pName+"\n");
            }
        }catch (Exception e){
            System.out.println("Error--"+e);
        }
        return playlist;
    }

    @Override
    public void deletePlaylist(String playlistId) {
        try {
            Connection con= DBConnection.getConnection();
            String searchQuery = "delete from Playlist where playlistId ='"+playlistId+"'";
            Statement statement = con.createStatement();
            statement.executeUpdate(searchQuery);
            System.out.println("Playlist Deleted");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void searchPlaylist(String playlistId) {
        try{
            Connection con= DBConnection.getConnection();
            String searchQuery = "select * from Playlist where playlistId ='"+playlistId+"'";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(searchQuery);
            while (resultSet.next()){
                String id =  resultSet.getString("playlistId");
                String pName = resultSet.getString("playlistName");
                System.out.println("playlistId"+"  "+"playlistName");
                System.out.println(" "+id+"    "+pName+"\n");
            }

        }catch (Exception e){
            System.out.println("Not Found"+e);
        }
    }
}
