package itamar.stern.backingtracks.presentation.guitar

import androidx.lifecycle.ViewModel
import itamar.stern.backingtracks.core.DialogsManager
import itamar.stern.backingtracks.core.TabsManager
import itamar.stern.backingtracks.core.Track
import itamar.stern.backingtracks.core.repository.SectionsRepository
import itamar.stern.backingtracks.media_player.MyMediaPlayer

class GuitarViewModel(
    private val audioManager: MyMediaPlayer,
    private val sectionsRepo: SectionsRepository,
    private val dialogsManager: DialogsManager
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
        TabsManager.clearTabs()
    }

    fun deleteStepClicked() {
        if (Track.section.isEmpty()) return
        audioManager.pauseAudio()
        Track.section.removeLast()
        if (Track.chordButtonMode.value == AddingNotesMode.CHORD) TabsManager.fillSpaces()
        TabsManager.removeLast()
    }

    fun chordBtnClicked() = with(Track) {
        when (chordButtonMode.value) {
            AddingNotesMode.SINGLE -> {
                section.add(mutableListOf())
                chordButtonMode.value = AddingNotesMode.CHORD
            }
            AddingNotesMode.CHORD -> {
                chordButtonMode.value = AddingNotesMode.SINGLE
                TabsManager.fillSpaces()
            }
        }
    }

    fun spaceBtnClicked() {
        Track.section.add(mutableListOf())
        if (Track.chordButtonMode.value == AddingNotesMode.CHORD) {
            TabsManager.fillSpaces()
            Track.chordButtonMode.value = AddingNotesMode.SINGLE
        }
        TabsManager.addSpace()
    }

    fun tempoChanged(tempo: Int) {
        Track.tempo.value = tempo
    }

    fun saveBtnClicked(sectionName: String) {
        sectionsRepo.saveSectionToDb(sectionName) {
            dialogsManager.showDialog(it.message, true)
        }
    }

    fun openSetClicked(sectionName: String) {
        sectionsRepo.openSet(sectionName)
    }
}