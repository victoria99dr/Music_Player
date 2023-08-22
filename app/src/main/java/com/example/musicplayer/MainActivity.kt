import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.musicplayer.R



class MainActivity : AppCompatActivity() {
    private lateinit var albumArtImageView: ImageView
    private lateinit var songTitleTextView: TextView
    private lateinit var artistTextView: TextView
    private lateinit var progressSeekBar: SeekBar
    private lateinit var playPauseButton: ImageButton

    private lateinit var mediaPlayer: MediaPlayer
    private var isPlaying = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayer = MediaPlayer.create(this, R.raw.sample_audio) // Replace with your audio resource

        // Initialize views
        albumArtImageView = findViewById(R.id.albumArtImageView)
        songTitleTextView = findViewById(R.id.songTitleTextView)
        artistTextView = findViewById(R.id.artistTextView)
        progressSeekBar = findViewById(R.id.progressSeekBar)
        playPauseButton = findViewById(R.id.playPauseButton)

        // Set click listeners
        playPauseButton.setOnClickListener {
            // Implement play/pause logic
            if (isPlaying) {
                pauseAudio()
            } else {
                playAudio()
            }
        }
        // Set other listeners and implement remaining logic
    }
    private fun playAudio() {
        mediaPlayer.start()
        isPlaying = true
        playPauseButton.setImageResource(R.drawable.ic_play) // Change button icon to pause
    }

    private fun pauseAudio() {
        mediaPlayer.pause()
        isPlaying = false
        playPauseButton.setImageResource(R.drawable.ic_play) // Change button icon to play
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release() // Release the media player when the activity is destroyed
    }
}



