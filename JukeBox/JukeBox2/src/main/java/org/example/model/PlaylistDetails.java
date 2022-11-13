package org.example.model;

public class PlaylistDetails {
    private String playlistDetailsId;

    public PlaylistDetails(String playlistDetailsId) {
        this.playlistDetailsId = playlistDetailsId;
    }

    public PlaylistDetails() {
    }

    public String getPlaylistDetailsId() {
        return playlistDetailsId;
    }

    public void setPlaylistDetailsId(String playlistDetailsId) {
        this.playlistDetailsId = playlistDetailsId;
    }
}
