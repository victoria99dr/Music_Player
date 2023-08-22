package com.example.musicplayer
import com.google.firebase.firestore.FirebaseFirestore

// Playlist.kt
data class Playlist(val name: String, val ownerId: String)

// PlaylistRepository.kt
class PlaylistRepository {
    private val db = FirebaseFirestore.getInstance()
    internal val playlistsCollection = db.collection("playlists")

    fun createPlaylist(playlist: Playlist) {
        playlistsCollection.add(playlist)
            .addOnSuccessListener {
                // Playlist created successfully
            }
            .addOnFailureListener {
                // Error creating playlist
            }
    }
}

