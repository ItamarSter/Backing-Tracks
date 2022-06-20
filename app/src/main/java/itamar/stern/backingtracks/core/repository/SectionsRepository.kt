package itamar.stern.backingtracks.core.repository

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import itamar.stern.backingtracks.core.Track
import itamar.stern.backingtracks.core.database.SectionsDB
import itamar.stern.backingtracks.core.modules.Section

class SectionsRepository(
    private val sectionsDB: SectionsDB,
    private val gson: Gson
) {
    fun saveSectionToDb(sectionName: String) {
        val jsonSection = getJsonSection()
        saveSectionToDb(jsonSection, sectionName)
    }

    fun openSet(sectionName: String) {
        Track.section.clear()
        val jsonSection = sectionsDB.sectionDao().getSetByName(sectionName).section
        Track.section.addAll(gson.fromJson(jsonSection, object : TypeToken<MutableList<MutableList<Int>>>(){}.type))
    }

    private fun getJsonSection(): String {
        return gson.toJson(Track.section)
    }

    private fun saveSectionToDb(jsonSection: String, sectionName: String) {
        sectionsDB.sectionDao().insertSection(Section(Math.random(), jsonSection, sectionName))
    }
}