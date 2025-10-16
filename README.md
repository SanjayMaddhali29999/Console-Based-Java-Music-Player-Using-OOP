🎵 Console-Based Java Music Player Using OOP

🚀 Project Overview

A menu-driven console application in Java that simulates a simple music player using Object-Oriented Programming (OOP) concepts.

Features:

Add, update, delete, and display songs

Create and manage playlists

Play, pause, and stop songs in playlists

Supports song selection by title or ID

🎯 Objective

Demonstrate core OOP concepts in a practical Java project while building an interactive music player application.

🧩 Core OOP Concepts Demonstrated
Concept	Usage
Encapsulation	Private fields with public getters/setters in classes like Song
Abstraction	Playable interface abstracts playback operations
Inheritance	Playlist class implements Playable
Polymorphism	Interface methods overridden in Playlist
Collections	ArrayList used to manage songs and playlists dynamically
📚 Class Breakdown
1️⃣ Song Class

Fields: songId, title, artist, duration

Purpose: Represents a song entity

Key Methods: Constructor, Getters/Setters, toString()

2️⃣ Playable Interface

Methods:
void play(String title);
void play(int songId);
void pause(String title);
void pause(int songId);
void stop(String title);
void stop(int songId);
Purpose: Abstract playback behavior for any class that implements it

3️⃣ Playlist Class (implements Playable)

Fields: playlistId, playlistName, List<Song>

Purpose: Represents a playlist with playback control

Key Methods:

addSong(Song)

removeSong(String/int)

displaySongs()

Implements play(), pause(), stop()

4️⃣ MusicPlayer Class

Fields: List<Song> allSongs, List<Playlist> playlists

Purpose: Manages songs and playlists

Key Methods:

addSong(String title, String artist, double duration)

updateSong(Song, String existingTitle)

deleteSong(String title)

displayAllSongs()

createPlaylist(String name)

addSongToPlaylist(String playlistName, Scanner sc)

displaySongsPlaylist(String playlistName)

Playback methods by title or ID (play, pause, stop)

5️⃣ Main Class

Menu-driven console interface to interact with MusicPlayer

Options for managing songs, playlists, and playback

📜 Menu Options
========= MUSIC PLAYER MENU =========
1. Add New Song
2. Update Existing Song
3. Delete Song
4. Display All Songs
5. Create New Playlist
6. Add Song to Playlist
7. Display All Playlists
8. Display Songs in Playlist
9. Play Song in Playlist
10. Pause Song in Playlist
11. Stop Song in Playlist
12. Exit
Enter your choice:

🖥️ Example Console Outputs with User Inputs
1️⃣ Add New Song
Enter song title: Shape of You
Enter artist name: Ed Sheeran
Enter duration: 4.5

Output:
Added song: Song [songId=1, title=Shape of You, artist=Ed Sheeran, duration=4.5]
2️⃣ Update Existing Song
Enter existing song title: Shape of You
Enter new title: Perfect
Enter new Artist: Ed Sheeran
Enter new duration: 4.7

Output:
Song updated: Song [songId=1, title=Perfect, artist=Ed Sheeran, duration=4.7]

3️⃣ Delete Song
Enter the song to delete: Perfect

Output:
Song deleted successfully!

4️⃣ Display All Songs
Output:
All Songs:
Song [songId=1, title=Perfect, artist=Ed Sheeran, duration=4.7]
Song [songId=2, title=Blinding Lights, artist=The Weeknd, duration=3.2]

5️⃣ Create Playlist
Enter playlist name: Party Hits

Output:
Created playlist: Party Hits

6️⃣ Add Song to Playlist

By ID
Enter playlist name: Party Hits
Choose how to add the song:
1. By Song ID
2. By Song Title
Enter your choice: 1
Enter Song ID: 2

Output:
✅ Song 'Blinding Lights' added to playlist 'Party Hits'.

By Title
Enter playlist name: Party Hits
Choose how to add the song:
1. By Song ID
2. By Song Title
Enter your choice: 2
Enter Song Title: Perfect

Output:
✅ Song 'Perfect' added to playlist 'Party Hits'.

7️⃣ Display All Playlists
Enter playlist name: Party Hits

Output:
Playlist: Party Hits

8️⃣ Display Songs in Playlist
Enter playlist name: Party Hits

Output:
Songs in playlist 'Party Hits':
Song [songId=1, title=Perfect, artist=Ed Sheeran, duration=4.7]
Song [songId=2, title=Blinding Lights, artist=The Weeknd, duration=3.2]

9️⃣ Play Song

By Title
Enter playlist name: Party Hits
Enter song title: Perfect

Output:
Now playing: Perfect
By ID

Enter playlist name: Party Hits
Enter song ID: 2

Output:
Song [songId=2, title=Blinding Lights, artist=The Weeknd, duration=3.2] is playing (by ID)

🔟 Pause Song

By Title

Enter playlist name: Party Hits
Enter song title: Perfect

Output:
Song paused: Perfect


By ID

Enter playlist name: Party Hits
Enter song ID: 2

Output:
Song paused (by ID): Blinding Lights

1️⃣1️⃣ Stop Song

By Title

Enter playlist name: Party Hits
Enter song title: Perfect

Output:
Stopped playing: Perfect


By ID

Enter playlist name: Party Hits
Enter song ID: 2

Output:
Song stopped (by ID): Blinding Lights

1️⃣2️⃣ Exit
Enter your choice: 12

Output:
Exiting music player.
Good Bye

✅ Conclusion

This project demonstrates Java OOP concepts with practical use of Encapsulation, Abstraction, Inheritance, Polymorphism, and Collections.
Technologies Used

Java (Core Java, OOP concepts)

Collections (ArrayList)

Console-based input/output

Project Highlights

Fully object-oriented design

Dynamic management of songs and playlists

Implements play, pause, stop functionality for songs

Menu-driven and user-friendly

Usage

Clone the repository:

git clone https://github.com/SanjayMaddhali29999/console-based-java-music-player-oop.git

Open the project in Eclipse or any Java IDE
Run Main.java to start the application
Follow the menu to manage songs and playlists

Author
Sanjay Maddhali

GitHub: https://github.com/SanjayMaddhali29999
