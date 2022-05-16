package itamar.stern.backingtracks.media_player

import itamar.stern.backingtracks.AddingNotesMode
import kotlinx.coroutines.flow.MutableStateFlow

object Track {
    val set = mutableListOf<MutableList<Int>>()

    val chordButtonMode = MutableStateFlow(AddingNotesMode.SINGLE)
}