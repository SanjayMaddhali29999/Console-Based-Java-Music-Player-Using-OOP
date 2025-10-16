package com.main;

import java.util.Scanner;

import com.model.Song;
import com.service.MusicPlayer;

public class Main {
	private static final Scanner sc = new Scanner(System.in);
	public static void displayMenu() {
			System.out.println("---Welcome to Music Player ---");
			System.out.println("1. Add New Song ");
			System.out.println("2. Update Existing Song");
			System.out.println("3. Delete Song");
			System.out.println("4. Display All Songs");
			System.out.println("5. Create New Playlist ");
			System.out.println("6. Add Song to Playlist");
			System.out.println("7. Display All Playlists ");
			System.out.println("8. Display Songs in Playlist");
			System.out.println("9. Play Song in Playlist");
			System.out.println("10. Pause Song in Playlist");
			System.out.println("11. Stop Song in Playlist ");
			System.out.println("12. Exit");
			System.out.println();
			System.out.print("Enter your choice ");
	}

	public static void main(String[] args) {
		boolean running = true;
		MusicPlayer musicplayer=new MusicPlayer();
		while (running) {
			displayMenu();
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1: {//Adding a song
				System.out.println("Enter song title");
				String title=sc.nextLine();
				System.out.println();
				System.out.println("Enter artist name");
				String artist=sc.nextLine();
				System.out.println();
				System.out.println("Enter duration");
				double duration=sc.nextDouble();
				System.out.println();
				musicplayer.addSong(title, artist, duration);
				break;
				
			}
			case 2: {  //update song
				System.out.println("Enter existing song title");
				String existingTitle=sc.nextLine();
				System.out.println("Enter new title");
				String newTitle=sc.nextLine();
				System.out.println("Enter new Artist");
				String newArtist=sc.nextLine();
				System.out.println("Enter new duration");
				double newDuration=sc.nextDouble();
				sc.nextLine();
				Song song=new Song(0, newTitle, newArtist, newDuration);
				musicplayer.updateSong(song, existingTitle);
				break;
			}
			case 3: {  //delete song
				System.out.println("Enter the song to delete");
				String title=sc.nextLine();
				musicplayer.deleteSong(title);
				break;
			}
			case 4: {  //display song
				musicplayer.displayAllSongs();
				break;

			}
			case 5: {  //create playlist
				System.out.println("Enter playlist name");
				String playlistName=sc.nextLine();
				musicplayer.createPlaylist(playlistName);
				break;
			}
			case 6: {//add song to playlist
			    System.out.print("Enter playlist name: ");
			    String playlistName = sc.nextLine();
			    musicplayer.addSongToPlaylist(playlistName, sc);
			    break;
			}
			
			case 7: { //display playlist
				System.out.println("Enter playlist name");
			    String playlistName = sc.nextLine();
				musicplayer.displayPlaylist(playlistName);
				break;
			}
			case 8: { //display songs in playlist
				System.out.println("Enter playlist name");
				String playlistName=sc.nextLine();
				musicplayer.displaySongsPlaylist(playlistName);
				break;
			}
		
			case 9: { // play
			    System.out.println("Play song by: 1. Title  2. ID");
			    int opt = sc.nextInt();
			    sc.nextLine();

			    System.out.print("Enter playlist name: ");
			    String playlistName = sc.nextLine();

			    if (opt == 1) {
			        System.out.print("Enter song title: ");
			        String title = sc.nextLine();
			        musicplayer.playInPlaylist(playlistName, title);
			    } else if (opt == 2) {
			        System.out.print("Enter song ID: ");
			        int id = sc.nextInt();
			        sc.nextLine();
			        musicplayer.playInPlaylistById(playlistName, id);
			    } else {
			        System.out.println("Invalid option");
			    }
			    break;
			}
			
			case 10: {
				System.out.println("Pause song by: 1. Title  2. ID");
			    int opt = sc.nextInt();
			    sc.nextLine();

			    System.out.print("Enter playlist name: ");
			    String playlistName = sc.nextLine();

			    if (opt == 1) {
			        System.out.print("Enter song title: ");
			        String title = sc.nextLine();
			        musicplayer.pauseInPlaylist(playlistName, title);
			    } else if (opt == 2) {
			        System.out.print("Enter song ID: ");
			        int id = sc.nextInt();
			        sc.nextLine();
			        musicplayer.pauseInPlaylistById(playlistName, id);
			    } else {
			        System.out.println("Invalid option");
			    }
			    break;
			}
			
			case 11: {
				System.out.println("Stop song by: 1. Title  2. ID");
			    int opt = sc.nextInt();
			    sc.nextLine();

			    System.out.print("Enter playlist name: ");
			    String playlistName = sc.nextLine();

			    if (opt == 1) {
			        System.out.print("Enter song title: ");
			        String title = sc.nextLine();
			        musicplayer.stopInPlaylist(playlistName, title);
			    } else if (opt == 2) {
			        System.out.print("Enter song ID: ");
			        int id = sc.nextInt();
			        sc.nextLine();
			        musicplayer.stopInPlaylistById(playlistName, id);
			    } else {
			        System.out.println("Invalid option");
			    }
			    break;
			}
			
			case 12: {
				running=false;
				System.out.println("Exiting music player. \n Good Bye");
				break;

			}
			default:
				System.out.println("Invalid choice.\n Please try again");
			}
			System.out.println();

		}

	}
}