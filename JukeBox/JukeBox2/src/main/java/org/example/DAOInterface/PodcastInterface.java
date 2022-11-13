package org.example.DAOInterface;

import org.example.model.Podcast;

import java.util.List;

public interface PodcastInterface {
    List<Podcast> displayAllPodcast();
    void searchPodcast(String podcastId);
    List<Podcast>sortPodcast();
    void playPodcast(String id);
}
