package org.example;

import static org.junit.Assert.assertTrue;


import org.example.DAOImplmentation.PodcastImpl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PodcastTest {

    PodcastImpl podcastImplObj=null;
    @BeforeEach
    public void setUp()
    {
        podcastImplObj=new PodcastImpl();
    }
    @AfterEach
    public void tearDown()
    {
        podcastImplObj=null;
    }
    @Test
    public void displayAllSongs()
    {
        assertEquals(4,podcastImplObj.displayAllPodcast().size());
        String expected="P73";
        String actual=podcastImplObj.displayAllPodcast().get(3).getPodcastId();
        assertEquals(expected,actual);
    }
    @Test
    public void searchSongs(){
        String expected="Why  do  we  dream ?";
        String actual=podcastImplObj.sortPodcast().get(3).getPodcastName();
        assertEquals(expected,actual);
    }
}


