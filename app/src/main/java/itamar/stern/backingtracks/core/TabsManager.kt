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

    private val modifiedLinesInChordMode = hashMapOf(
        Pair(tabLinesMap["6"], false),
        Pair(tabLinesMap["5"], false),
        Pair(tabLinesMap["4"], false),
        Pair(tabLinesMap["3"], false),
        Pair(tabLinesMap["2"], false),
        Pair(tabLinesMap["1"], false)
    )

    fun addSingleTab(line: String, fret: String) {
        foreachTabs { lineMap ->
            if (lineMap.key == line) {
                lineMap.value.value += ("-$fret-")
            } else {
                addSpaceToTabLine(lineMap)
            }
        }
    }

    fun addTabInChordMode(line: String, fret: String) {
        if(modifiedLinesInChordMode[tabLinesMap[line]] == false) tabLinesMap[line]?.value += ("-$fret-")
        modifiedLinesInChordMode[tabLinesMap[line]] = true
    }

    fun clearTabs() {
        foreachTabs { lineMap ->
            lineMap.value.value = lineMap.value.value.substring(0, 4)
        }
        resetModifiedInChordMode()
    }

    fun removeLast() {
        foreachTabs { lineMap ->
            lineMap.value.value = lineMap.value.value.dropLast(3)
        }
        resetModifiedInChordMode()
    }

    fun addSpace() {
        foreachTabs { lineMap ->
            addSpaceToTabLine(lineMap)
        }
        resetModifiedInChordMode()
    }

    fun fillSpaces() {
        var length = 0
        foreachTabs { lineMap ->
            if (length < lineMap.value.value.length) length = lineMap.value.value.length
        }
        foreachTabs { lineMap ->
            if (lineMap.value.value.length < length) addSpaceToTabLine(lineMap)
        }
        resetModifiedInChordMode()
    }

    private fun foreachTabs(todo: (MutableMap.MutableEntry<String, MutableStateFlow<String>>) -> Unit) {
        for (lineMap in tabLinesMap) {
            todo(lineMap)
        }
    }

    private fun addSpaceToTabLine(lineMap: MutableMap.MutableEntry<String, MutableStateFlow<String>>) {
        lineMap.value.value += ("---")
    }

    private fun resetModifiedInChordMode() {
        for (modifyingFlag in modifiedLinesInChordMode) {
            modifyingFlag.setValue(false)
        }
    }
}