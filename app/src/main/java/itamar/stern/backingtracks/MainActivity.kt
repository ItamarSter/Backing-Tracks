package itamar.stern.backingtracks

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RawRes
import itamar.stern.backingtracks.databinding.ActivityMainBinding
import itamar.stern.backingtracks.media_player.MyMediaPlayer
import itamar.stern.backingtracks.media_player.Track
import java.sql.Time
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MyMediaPlayer
    private lateinit var binding: ActivityMainBinding
    private val set get() = Track.set
    private var timer = Timer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mediaPlayer = MyMediaPlayer(this)
        setViews()
    }

    private fun runSet() {
        var count = 0
        timer.cancel()
        timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                mediaPlayer.startAudio(set[count])
                if (count < set.size - 1) count++ else count = 0
            }
        }, 0, 300)
    }

    private fun setViews() = binding.apply {
        btnStartSet.setOnClickListener {
            if (set.isNotEmpty()) runSet()
        }
        btnPauseSet.setOnClickListener {
            timer.cancel()
        }
        btnResetSet.setOnClickListener {
            timer.cancel()
            set.clear()
        }
        btnDeleteStep.setOnClickListener {
            timer.cancel()
            set.removeLast()
        }
    }
}