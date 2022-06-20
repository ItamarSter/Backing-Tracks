package itamar.stern.backingtracks.media_player

import android.content.Context
import android.media.MediaPlayer
import itamar.stern.backingtracks.core.Track
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*

class MyMediaPlayer(
    private val context: Context
) {

    private var timer = Timer()
    private var tempo = 250L

    init {
        GlobalScope.launch {
            collectTempo()
        }
    }

    private suspend fun collectTempo() {
        Track.tempo.collect { tempo ->
            this.tempo = (60000 / tempo).toLong()
        }
    }

    fun getPreparedMediaPlayersList(audioFilesList: List<Int>): MutableList<MediaPlayer?> {
        val preparedMediaPlayersList = mutableListOf<MediaPlayer?>()
        for (audioFile in audioFilesList) {
            try {
                preparedMediaPlayersList.add(MediaPlayer.create(context, audioFile))
            } catch (e: Throwable) {
                //problem in the audio file
            }
        }
        return preparedMediaPlayersList
    }

    fun startAudio(mediaPlayer: MediaPlayer?) {
        mediaPlayer?.run {
            start()
            setOnCompletionListener {
                it.release()
            }
        }
    }

    fun pauseAudio() {
        timer.cancel()
    }

    private var sectionCount = 0
    private var sectionMediaPlayersList = mutableListOf<MediaPlayer?>()

    private fun prepareNextNoteOfSet() {
        sectionMediaPlayersList = getPreparedMediaPlayersList(Track.section[sectionCount])
    }

    fun runSet() {
        prepareNextNoteOfSet()
        timer.cancel()
        timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                for (mediaPlayer in sectionMediaPlayersList) {
                    startAudio(mediaPlayer)
                }
                if (sectionCount < Track.section.size - 1) sectionCount++ else sectionCount = 0
                prepareNextNoteOfSet()
            }
        }, 0, tempo)
    }
}