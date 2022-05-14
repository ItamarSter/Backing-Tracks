package itamar.stern.backingtracks.media_player

import android.content.Context
import android.media.MediaPlayer
import androidx.annotation.RawRes

class MyMediaPlayer(
    private val context: Context
) {
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
}