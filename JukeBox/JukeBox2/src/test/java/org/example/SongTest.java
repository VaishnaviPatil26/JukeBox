package org.example;

import static org.junit.Assert.assertTrue;


import org.example.DAOImplmentation.SongsImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SongTest {

    SongsImpl songsImplObj=null;
    @BeforeEach
    public void setUp()
    {
        songsImplObj=new SongsImpl();
    }
    @AfterEach
    public void tearDown()
    {
        songsImplObj=null;
    }
    @Test
    public void displayAllSongs()
    {
        assertEquals(9,songsImplObj.displayAllSongs().size());
        String expected= "S76";
        String actual=songsImplObj.displayAllSongs().get(7).getSongId();
        assertEquals(expected,actual);
    }

    @Test
    public void sortSongs(){
        String expected= "Samjhawan";
        String actual=songsImplObj.sortSong().get(6).getSongName();
        assertEquals(expected,actual);

        String expectedartist = "Varun";
        String actualactual =songsImplObj.sortSong().get(2).getArtistName();
        assertEquals(expected,actual);
    }

}

