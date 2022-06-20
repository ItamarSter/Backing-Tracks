package itamar.stern.backingtracks.core.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import itamar.stern.backingtracks.core.modules.Section

const val DB_VERSION = 2
const val DB_NAME = "SectionsDatabase"

@Database(entities = [Section::class], version = DB_VERSION)
abstract class SectionsDB : RoomDatabase() {
    companion object {
        fun create(context: Context): SectionsDB {
            return Room.databaseBuilder(context, SectionsDB::class.java, DB_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
    abstract fun sectionDao(): SectionDao
}