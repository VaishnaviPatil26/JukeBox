package org.example.model;

public class Songs {
    private String songId;
    private String songName;
    private String artistName;
    private String genre;
    private String filepath;
    private String duration;

    public Songs(String songId,String songName,String artistName, String genre, String duration) {
        this.songId = songId;
        this.songName = songName;
        this.artistName = artistName;
        this.genre = genre;
        this.duration = duration;
    }

    public Songs() {
    }

    public Songs(String songId,String songName,String artistName, String genre, String filepath, String duration) {
        this.songId = songId;
        this.songName = songName;
        this.artistName = artistName;
        this.genre = genre;
        this.filepath = filepath;
        this.duration = duration;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    @Override
    public String toString() {
        return  songId + "\t\t" + songName +"\t\t"+artistName+"\t\t\t"+ genre+ "\t\t"+duration;
    }
}
