package org.example.DAOInterface;

import org.example.model.Songs;

import java.util.List;

public interface SongInterface {
    List<Songs> displayAllSongs();
    void searchSong(String id);
    List<Songs>sortSong();
    void playSongs(String genre);
}
