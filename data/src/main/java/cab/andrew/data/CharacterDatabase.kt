package cab.andrew.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import cab.andrew.data.daos.CharacterDao
import cab.andrew.data.entities.CharacterCacheEntity
import cab.andrew.data.utils.Converters

@Database(entities = [CharacterCacheEntity::class], version = 1, exportSchema = false)
abstract class CharacterDatabase : RoomDatabase() {
	abstract fun characterDao(): CharacterDao

	companion object {
		val DATABASE_NAME: String = "character_db"
	}
}
