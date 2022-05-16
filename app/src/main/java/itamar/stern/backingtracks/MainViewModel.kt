package itamar.stern.backingtracks

import androidx.lifecycle.ViewModel
import itamar.stern.backingtracks.media_player.MyMediaPlayer
import itamar.stern.backingtracks.media_player.Track

class MainViewModel(
    private val audioManager: MyMediaPlayer
) : ViewModel() {



    fun startSetClicked() {
        if (Track.set.isNotEmpty()) audioManager.runSet()
    }

    fun pauseSetClicked() {
        audioManager.pauseAudio()
    }

    fun resetSetClicked() {
        audioManager.pauseAudio()
        Track.set.clear()
    }

    fun deleteStepClicked() {
        audioManager.pauseAudio()
        Track.set.removeLast()
    }

    fun chordBtnClicked() = with(Track) {
        when (chordButtonMode.value) {
            AddingNotesMode.SINGLE -> {
                set.add(mutableListOf())
                chordButtonMode.value = AddingNotesMode.CHORD
            }
            AddingNotesMode.CHORD -> {
                chordButtonMode.value = AddingNotesMode.SINGLE
            }
        }
    }

}