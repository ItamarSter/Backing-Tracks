package itamar.stern.backingtracks.core.database

import android.graphics.Movie
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import itamar.stern.backingtracks.core.modules.Section

@Dao
interface SectionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSection(section: Section)

    @Query("SELECT * FROM section WHERE name=:sectionName LIMIT 1")
    fun getSetByName(sectionName: String): Section
}