package org.example.DAOImplmentation;

import org.example.DBConnection;
import org.example.DAOInterface.SongInterface;
import org.example.model.Songs;
import org.example.service.PlayAudioService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class SongsImpl implements SongInterface {

    public void readAudio(String audioSrcFile, int count) {
        PlayAudioService playAudio = new PlayAudioService();
        int c = 0;
        count = count - 1;
        try {
            playAudio.playAudio1(audioSrcFile, count);
            playAudio.play();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1. pause");
                System.out.println("2. resume");
                System.out.println("3. restart");
                System.out.println("4. stop");
                System.out.print("Enter your choice if You want to pause/resume/restart/stop : ");
                if (c == 4) {
                    break;
                }

                if (scanner.hasNextInt()) {
                    //System.out.print("Enter : ");
                    c = scanner.nextInt();
                } else {
                    break;
                }
                switch (c) {
                    case 1:
                        playAudio.pause();
                        break;
                    case 2:
                        playAudio.resumeAudio();
                        break;
                    case 3:
                        playAudio.restart();
                        break;
                    case 4:
                        playAudio.stop();
                        break;
                }
            }
        } catch (Exception ex) {
            System.out.println("Error with playing sound." + ex);
        }
    }


    @Override
    public List<Songs> displayAllSongs() {
        List<Songs> songlist = new ArrayList<>();
        try {
            Connection con= DBConnection.getConnection();
            String query="select * from Songs";
            Statement st= con.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                String songId=rs.getString("songId");
                String songName=rs.getString("songName");
                String artName = rs.getString("artistName");
                String genre = rs.getString("genre");
                String time = rs.getString("duration");
                Songs obj=new Songs(songId,songName,artName,genre,time);
                songlist.add(obj);
            }
        }catch (Exception e){
            System.out.println("Error--"+e);
        }
        return songlist;
    }

    @Override
    public void searchSong(String id) {
        try{
            Connection con= DBConnection.getConnection();
            String searchQuery = "select * from Songs where songId ='"+id+"'";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(searchQuery);
            while (resultSet.next()){
                String name =  resultSet.getString("songName");
                String artName = resultSet.getString("artistName");
                String genre = resultSet.getString("genre");
                String time = resultSet.getString("duration");

                System.out.println("\nSongId  Song Name  Artist      Genre      Duration");
                System.out.println("\n"+id+"    "+name+"  "+artName+"  "+genre+"  "+time+"\n");
            }

        }catch (Exception e){
            System.out.println("Not Found"+e);
        }
    }

    @Override
    public List<Songs> sortSong() {
        List<Songs> songList = new ArrayList<>();
        try {
            Connection con= DBConnection.getConnection();
            String query="select * from Songs order by songName";
            Statement st= con.createStatement();
            ResultSet rs1=st.executeQuery(query);
            while(rs1.next())
            {
                String songId=rs1.getString("songId");
                String songName=rs1.getString("songName");
                String artName = rs1.getString("artistName");
                String genre = rs1.getString("genre");
                String time = rs1.getString("duration");
                Songs obj=new Songs(songId,songName,artName,genre,time);
                songList.add(obj);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return songList;
    }

    @Override
    public void playSongs(String songId) {
        try{
            Connection con= DBConnection.getConnection();
            String getSongQuery = "select * from Songs where songId='"+songId+"'";
            Statement st = con.createStatement();
            ResultSet rs2 = st.executeQuery(getSongQuery);
            while (rs2.next()){
                String getPath = rs2.getString("filepath");
                String newPath = getPath.replaceAll("\"","");
                //System.out.println("path is == "+newPath);
                readAudio(newPath , 2);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
