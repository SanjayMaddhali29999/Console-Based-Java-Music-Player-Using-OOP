package com.service;

import java.util.ArrayList;
import java.util.List;

import com.contract.Playable;
import com.model.Song;

public class PlayList implements Playable {
    private int playlistId;
    private String playlistName;
    private List<Song> songs = new ArrayList<>();
    private Song currentlyPlaying = null;
    private boolean paused = false;

    public PlayList(int playlistId, String playlistName) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void displaySongs() {
        if (songs.isEmpty()) {
            System.out.println("No songs in playlist: " + playlistName);
        } else {
            System.out.println("Songs in playlist '" + playlistName + "':");
            for (Song song : songs) {
                System.out.println(song);
            }
        }
    }

    @Override
    public void play(String title) {
        Song songToPlay = null;
        for (Song song : songs) {
            if (song.getTitle() != null && song.getTitle().equalsIgnoreCase(title)) {
                songToPlay = song;
                break;
            }
        }

        if (songToPlay != null) {
            currentlyPlaying = songToPlay;
            paused = false;
            System.out.println("Now playing: " + songToPlay.getTitle());
        } else {
            System.out.println("Song not found in playlist.");
        }
    }

    @Override
    public void pause(String title) {
        if (currentlyPlaying != null && currentlyPlaying.getTitle().equalsIgnoreCase(title)) {
            if (!paused) {
                paused = true;
                System.out.println("Song paused: " + title);
            } else {
                System.out.println("Song is already paused.");
            }
        } else {
            System.out.println("No song currently playing to pause.");
        }
    }

    @Override
    public void stop(String title) {
        if (currentlyPlaying != null && currentlyPlaying.getTitle().equalsIgnoreCase(title)) {
            System.out.println("Stopped playing: " + title);
            currentlyPlaying = null;
            paused = false;
        } else {
            System.out.println("No song is currently playing to stop.");
        }
    }

    @Override
    	public void play(int songId) {
    	    Song songObj = null;
    	    for (Song song : songs) {
    	        if (song.getSongId() == songId) {
    	            songObj = song;
    	            break;
    	        }
    	    }
    	    if (songObj != null) {
    	        currentlyPlaying = songObj;
    	        paused = false;
    	        System.out.println(songObj + " is playing (by ID)");
    	    } else {
    	        System.out.println("Song with ID " + songId + " not found in playlist");
    	    }
    	}
    
    @Override public void pause(int songId) {
    	if (currentlyPlaying != null && currentlyPlaying.getSongId() == songId) {
            if (!paused) {
                paused = true;
                System.out.println("Song paused (by ID): " + currentlyPlaying.getTitle());
            } else {
                System.out.println("Already paused");
            }
        } else {
            System.out.println("Nothing to pause, please play a song first");
        }
    }
    @Override public void stop(int songId) {
    	if (currentlyPlaying != null && currentlyPlaying.getSongId() == songId) {
            System.out.println("Song stopped (by ID): " + currentlyPlaying.getTitle());
            currentlyPlaying = null;
            paused = false;
        } else {
            System.out.println("No such song is currently playing to stop");
        }
    }

    @Override
    public String toString() {
        return "PlayList [playlistId=" + playlistId + ", playlistName=" + playlistName + "]";
    }
}
