import com.google.firebase.firestore.FieldValue
import androidx.appcompat.app.AppCompatActivity
import com.example.musicplayer.Playlist
import com.example.musicplayer.PlaylistRepository

// Song.kt
data class Song(val title: String, val artist: String, val url: String)

// PlaylistDetailActivity.kt
class PlaylistDetailActivity : AppCompatActivity() {
    private val playlistRepository = PlaylistRepository()
    private lateinit var playlist: Playlist

    private fun addSongToPlaylist(song: Song) {
        // Assuming you have a playlist ID
        val playlistId = "your_playlist_id"

        val songData = hashMapOf(
            "title" to song.title,
            "artist" to song.artist,
            "url" to song.url
        )

        val playlistRef = playlistRepository.playlistsCollection.document(playlistId)
        playlistRef.update("songs", FieldValue.arrayUnion(songData))
            .addOnSuccessListener {
                // Song added to playlist successfully
            }
            .addOnFailureListener {
                // Error adding song to playlist
            }
    }
}
