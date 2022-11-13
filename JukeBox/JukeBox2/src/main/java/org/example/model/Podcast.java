package org.example.model;

public class Podcast {
    private String podcastId;
    private String podcastName;
    private String filepath;
    private String celebrityName;
    private int yearOfPodcast;


    public Podcast() {
    }

    public Podcast(String podcastId, String podcastName, String celebrityName, int yearOfPodcast) {
        this.podcastId = podcastId;
        this.podcastName = podcastName;
        this.celebrityName = celebrityName;
        this.yearOfPodcast = yearOfPodcast;
    }

    public Podcast(String podcastId, String podcastName, String filepath, String celebrityName, int yearOfPodcast) {
        this.podcastId = podcastId;
        this.podcastName = podcastName;
        this.filepath = filepath;
        this.celebrityName = celebrityName;
        this.yearOfPodcast = yearOfPodcast;
    }

    public String getPodcastId() {
        return podcastId;
    }

    public void setPodcastId(String podcastId) {
        this.podcastId = podcastId;
    }

    public String getPodcastName() {
        return podcastName;
    }

    public void setPodcastName(String podcastName) {
        this.podcastName = podcastName;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getCelebrityName() {
        return celebrityName;
    }

    public void setCelebrityName(String celebrityName) {
        this.celebrityName = celebrityName;
    }

    public int getYearOfPodcast() {
        return yearOfPodcast;
    }

    public void setYearOfPodcast(int yearOfPodcast) {
        this.yearOfPodcast = yearOfPodcast;
    }


    @Override
    public String toString() {
        return   podcastId + "\t\t" + podcastName +"\t\t"+celebrityName+"\t\t\t"+ yearOfPodcast;
    }
}
