package cab.andrew.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cab.andrew.data.entities.CharacterCacheEntity
import cab.andrew.data.models.Character
import com.squareup.moshi.JsonClass

@Dao
interface CharacterDao {
	@Query("SELECT * FROM characters")
	suspend fun getAllCharacters() : List<CharacterCacheEntity>

	@Query("SELECT * FROM characters WHERE id = :id")
	suspend fun getCharacter(id: Int?): CharacterCacheEntity

	@Query("SELECT * FROM characters WHERE description LIKE '%' || :text || '%'")
	suspend fun getCharacterWithName(text: String): CharacterCacheEntity

	@Query("DELETE FROM characters")
	suspend fun deleteCache()

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertAll(characterCaches: List<CharacterCacheEntity>)

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insert(character: CharacterCacheEntity) : Long

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun update(characterCache: CharacterCacheEntity)

	@Query("SELECT COUNT(*) FROM characters")
	suspend fun numCharacters(): Int
}
