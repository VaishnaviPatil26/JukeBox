package org.example.service;

import org.example.DAOInterface.PlaylistInterface;
import org.example.DBConnection;
import org.example.DAOInterface.PlaylistDetailsInterface;
import org.example.DAOImplmentation.PlaylistDetailsImpl;

import java.sql.Connection;
import java.util.Scanner;

public class PlaylistDetailsService {
    Scanner sc = new Scanner(System.in);
    PlaylistDetailsInterface playlistDetailsInterface = new PlaylistDetailsImpl();
    PlaylistInterface playlistInterface;
    public void playlistDetailMenu(int id){

        while (true) {
            try {
                System.out.println("---------------------------------------------------------------------");
                System.out.println("--------------------------- Your Playlist Details---------------------------");
                Connection con = DBConnection.getConnection();
                playlistDetailsInterface.displayMyPlaylistDetails(id);
                System.out.println("---------------------------------------------------------------------");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
