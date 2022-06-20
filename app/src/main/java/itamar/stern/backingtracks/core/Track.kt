package itamar.stern.backingtracks.core

import itamar.stern.backingtracks.presentation.AddingNotesMode
import kotlinx.coroutines.flow.MutableStateFlow

object Track {
    val section = mutableListOf<MutableList<Int>>()

    val chordButtonMode = MutableStateFlow(AddingNotesMode.SINGLE)

    val tempo = MutableStateFlow(250)
}