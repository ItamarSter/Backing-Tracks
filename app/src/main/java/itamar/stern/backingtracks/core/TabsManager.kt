package itamar.stern.backingtracks.core

import kotlinx.coroutines.flow.MutableStateFlow
import java.lang.StringBuilder

object TabsManager {
    val tabLinesMap = hashMapOf(
        Pair("6", MutableStateFlow(" E|-")),
        Pair("5", MutableStateFlow(" B|-")),
        Pair("4", MutableStateFlow(" G|-")),
        Pair("3", MutableStateFlow(" D|-")),
        Pair("2", MutableStateFlow(" A|-")),
        Pair("1", MutableStateFlow(" E|-"))
    )

    fun addSingleTab(line: String, fret: String) {
        for (lineMap in tabLinesMap) {
            if (lineMap.key == line) {
                lineMap.value.value += ("-$fret-")
            } else {
                lineMap.value.value += ("---")
            }
        }
    }
}