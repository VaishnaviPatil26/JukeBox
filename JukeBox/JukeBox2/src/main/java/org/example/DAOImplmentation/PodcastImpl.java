package org.example.DAOImplmentation;

import org.example.DBConnection;
import org.example.DAOInterface.PodcastInterface;
import org.example.model.Podcast;
import org.example.service.PlayAudioService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PodcastImpl implements PodcastInterface {

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
                    System.out.print("Enter : ");
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
    public List<Podcast> displayAllPodcast() {
        List<Podcast> podcastlist = new ArrayList<>();
        try {
            Connection con= DBConnection.getConnection();
            String query="select * from Podcast";
            Statement st= con.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                String id =  rs.getString("podcastId");
                String pName = rs.getString("podcastName");
                String celebrityname = rs.getString("celebrityName");
                int year = rs.getInt("yearofPoadcast");
                Podcast obj=new Podcast(id,pName,celebrityname,year);
                podcastlist.add(obj);
            }
        }catch (Exception e){
            System.out.println("Error--"+e);
        }
        return podcastlist;
    }

    @Override
    public void searchPodcast(String podcastId) {
        try{
            Connection con= DBConnection.getConnection();
            String searchQuery = "select * from Podcast where podcastId ='"+podcastId+"'";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(searchQuery);
            while (resultSet.next()){
                String id =  resultSet.getString("podcastId");
                String pName = resultSet.getString("podcastName");
                String celebrityname = resultSet.getString("celebrityName");
                int year = resultSet.getInt("yearofPoadcast");
                System.out.println("podcastId"+"  "+"podcastName"+"        "+"celebrityName"+"  "+"yearOfPodcast");
                System.out.println(" "+id+"    "+pName+"  "+celebrityname+"            "+year+"\n");
            }
        }catch (Exception e){System.out.println("Not Found"+e);}
    }
    @Override
    public List<Podcast> sortPodcast() {
        List<Podcast> podcasts = new ArrayList<>();
        try {
            Connection con= DBConnection.getConnection();
            String query="select * from Podcast order by podcastName";
            Statement st= con.createStatement();
            ResultSet rs1=st.executeQuery(query);
            while(rs1.next())
            {
                String id =  rs1.getString("podcastId");
                String pName = rs1.getString("podcastName");
                String celebrityname = rs1.getString("celebrityName");
                int year = rs1.getInt("yearofPoadcast");
                Podcast obj=new Podcast(id,pName,celebrityname,year);
                podcasts.add(obj);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return podcasts;
    }

    @Override
    public void playPodcast(String id) {
        try{
            Connection con= DBConnection.getConnection();
            String getPodcastQuery = "select * from Podcast where podcastId='"+id+"'";
            Statement st = con.createStatement();
            ResultSet rs2 = st.executeQuery(getPodcastQuery);
            while (rs2.next()){
                String getPath = rs2.getString("filepath");
                String newPath = getPath.replaceAll("\"","");
                readAudio(newPath , 2);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
