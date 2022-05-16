package itamar.stern.backingtracks.media_player

import android.content.Context
import android.media.MediaPlayer
import android.media.SoundPool
import androidx.annotation.RawRes
import itamar.stern.backingtracks.R
import java.util.*

class MyMediaPlayer(
    private val context: Context
) {

    private var timer = Timer()

    fun startAudio(@RawRes audioFile: Int) {
        try {
            MediaPlayer.create(context, audioFile).apply {
                start()
                setOnCompletionListener {
                    it.release()
                }
            }
        } catch (e: Throwable) {
            //problem in the audio file
        }
    }

    fun pauseAudio(){
        timer.cancel()
    }

    fun runSet() {
        var count = 0
        timer.cancel()
        timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                for (note in Track.set[count]) {
                    startAudio(note)
                }
                if (count < Track.set.size - 1) count++ else count = 0
            }
        }, 0, 250)
    }
}