package org.example.DAOInterface;

import org.example.model.Playlist;

import java.util.List;


public interface PlaylistInterface {
    void createNewPlaylist(int id);
    List<Playlist> displayMyPlaylist(int id);
    void deletePlaylist(String playlistId);
    void searchPlaylist(String playlistId);
}
