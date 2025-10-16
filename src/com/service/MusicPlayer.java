package com.service;

import java.util.ArrayList;
import java.util.List;
import com.model.Song;
import java.util.Scanner;

public class MusicPlayer {
    private final List<Song> allSongs = new ArrayList<>();
    private final List<PlayList> playlists = new ArrayList<>();
    private int songIdCounter = 1;
    private int playlistCounter = 1;

    public Song addSong(String title, String artist, double duration) {
        Song song = new Song(songIdCounter++, title, artist, duration);
        allSongs.add(song);
        System.out.println("Added song: " + song);
        return song;
    }

    public void displayAllSongs() {
        if (allSongs.isEmpty()) {
            System.out.println("No songs available.");
        } else {
            System.out.println("All Songs:");
            for (Song song : allSongs) {
                System.out.println(song);
            }
        }
    }

    public void deleteSong(String title) {
        Song found = null;
        for (Song song : allSongs) {
            if (song.getTitle() != null && song.getTitle().equalsIgnoreCase(title)) {
                found = song;
                break;
            }
        }
        if (found != null) {
            allSongs.remove(found);
            System.out.println("Song deleted successfully!");
        } else {
            System.out.println("Song not found!");
        }
    }

    public void updateSong(Song song, String existingTitle) {
        Song existed = null;
        for (Song s : allSongs) {
            if (s.getTitle() != null && s.getTitle().equalsIgnoreCase(existingTitle)) {
                existed = s;
                break;
            }
        }

        if (existed == null) {
            System.out.println("Song not found.");
        } else {
            existed.setTitle(song.getTitle());
            existed.setArtist(song.getArtist());
            existed.setDuration(song.getDuration());
            System.out.println("Song updated: " + existed);
        }
    }

    public void createPlaylist(String playlistName) {
        if (playlistName == null || playlistName.isEmpty()) {
            System.out.println("Invalid playlist name.");
            return;
        }

        for (PlayList play : playlists) {
            if (play.getPlaylistName().equalsIgnoreCase(playlistName)) {
                System.out.println("Playlist '" + playlistName + "' already exists.");
                return;
            }
        }

        PlayList p = new PlayList(playlistCounter++, playlistName);
        playlists.add(p);
        System.out.println("Created playlist: " + p.getPlaylistName());
    }

    
    public void displayPlaylist(String playlistName) {
        PlayList playlist = null;
        for (PlayList play : playlists) {
            if (play.getPlaylistName() != null && play.getPlaylistName().equalsIgnoreCase(playlistName)) {
                playlist = play;
                break;
            }
        }

        if (playlist == null) {
            System.out.println("Playlist not found.");
        } else {
            System.out.println("Playlist: " + playlist.getPlaylistName());
        }
    }
    public void addSongToPlaylist(String playlistName, Scanner sc) {
        // Find playlist
        PlayList playlist = null;
        for (PlayList play : playlists) {
            if (play.getPlaylistName() != null && play.getPlaylistName().equalsIgnoreCase(playlistName)) {
                playlist = play;
                break;
            }
        }

        if (playlist == null) {
            System.out.println("❌ Playlist not found. Please create it first.");
            return;
        }

        // Ask user how to add the song
        System.out.println("Choose how to add the song:");
        System.out.println("1. By Song ID");
        System.out.println("2. By Song Title");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        Song songToAdd = null;

        switch (choice) {
            case 1: {
                System.out.print("Enter Song ID: ");
                int songId = sc.nextInt();
                sc.nextLine();
                for (Song song : allSongs) {
                    if (song.getSongId() == songId) {
                        songToAdd = song;
                        break;
                    }
                }
                break;
            }

            case 2: {
                System.out.print("Enter Song Title: ");
                String title = sc.nextLine();
                for (Song song : allSongs) {
                    if (song.getTitle() != null && song.getTitle().equalsIgnoreCase(title)) {
                        songToAdd = song;
                        break;
                    }
                }
                break;
            }

            default:
                System.out.println("❌ Invalid choice. Returning to main menu.");
                return;
        }

        // Validation for song existence
        if (songToAdd == null) {
            System.out.println("❌ Song not found. Please check the available songs first.");
            return;
        }

        // Duplicate check
        for (Song s : playlist.getSongs()) {
            if (s.getSongId() == songToAdd.getSongId()) {
                System.out.println("⚠️ Song '" + songToAdd.getTitle() + "' is already in the playlist '" + playlistName + "'.");
                return;
            }
        }

        // Add song to playlist
        playlist.getSongs().add(songToAdd);
        System.out.println("✅ Song '" + songToAdd.getTitle() + "' added to playlist '" + playlistName + "'.");
    }


    public void displaySongsPlaylist(String playlistName) {
        PlayList playlist = null;
        for (PlayList play : playlists) {
            if (play.getPlaylistName() != null && play.getPlaylistName().equalsIgnoreCase(playlistName)) {
                playlist = play;
                break;
            }
        }

        if (playlist == null) {
            System.out.println("Playlist not found.");
        } else {
            playlist.displaySongs();
        }
    }

    public void playInPlaylist(String playlistName, String title) {
        PlayList playlist = findPlaylist(playlistName);
        if (playlist != null) playlist.play(title);
        else System.out.println("Playlist not found.");
    }

    public void pauseInPlaylist(String playlistName, String title) {
        PlayList playlist = findPlaylist(playlistName);
        if (playlist != null) playlist.pause(title);
        else System.out.println("Playlist not found.");
    }

    public void stopInPlaylist(String playlistName, String title) {
        PlayList playlist = findPlaylist(playlistName);
        if (playlist != null) playlist.stop(title);
        else System.out.println("Playlist not found.");
    }
    public void playInPlaylistById(String playlistName, int songId) {
        PlayList playlist = findPlaylist(playlistName);
        if (playlist != null) {
            playlist.play(songId);
        } else {
            System.out.println("Playlist not found");
        }
    }

    public void pauseInPlaylistById(String playlistName, int songId) {
        PlayList playlist = findPlaylist(playlistName);
        if (playlist != null) {
            playlist.pause(songId);
        } else {
            System.out.println("Playlist not found");
        }
    }

    public void stopInPlaylistById(String playlistName, int songId) {
        PlayList playlist = findPlaylist(playlistName);
        if (playlist != null) {
            playlist.stop(songId);
        } else {
            System.out.println("Playlist not found");
        }
    }

    // helper
    private PlayList findPlaylist(String playlistName) {
        for (PlayList play : playlists) {
            if (play.getPlaylistName().equalsIgnoreCase(playlistName)) {
                return play;
            }
        }
        return null;
    }
}
