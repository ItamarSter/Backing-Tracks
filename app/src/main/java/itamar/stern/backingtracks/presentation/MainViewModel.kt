package itamar.stern.backingtracks.presentation

import androidx.lifecycle.ViewModel
import itamar.stern.backingtracks.core.TabsManager
import itamar.stern.backingtracks.media_player.MyMediaPlayer
import itamar.stern.backingtracks.core.Track

class MainViewModel(
    private val audioManager: MyMediaPlayer
) : ViewModel() {



    fun startSetClicked() {
        if (Track.section.isNotEmpty()) audioManager.runSet()
    }

    fun pauseSetClicked() {
        audioManager.pauseAudio()
    }

    fun resetSetClicked() {
        audioManager.pauseAudio()
        Track.section.clear()
        TabsManager.cleanTabs()
    }

    fun deleteStepClicked() {
        if (Track.section.isEmpty()) return
        audioManager.pauseAudio()
        Track.section.removeLast()
    }

    fun chordBtnClicked() = with(Track) {
        when (chordButtonMode.value) {
            AddingNotesMode.SINGLE -> {
                section.add(mutableListOf())
                chordButtonMode.value = AddingNotesMode.CHORD
            }
            AddingNotesMode.CHORD -> {
                chordButtonMode.value = AddingNotesMode.SINGLE
            }
        }
    }

    fun spaceBtnClicked() {
        Track.section.add(mutableListOf())
        Track.chordButtonMode.value = AddingNotesMode.SINGLE
    }
}