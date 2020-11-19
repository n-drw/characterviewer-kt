package cab.andrew.data.daos

import cab.andrew.data.entities.CharacterCacheEntity

interface CharacterDaoService {
	suspend fun insertAll(characterCaches: List<CharacterCacheEntity>)

	suspend fun insert(characterCache: CharacterCacheEntity) : Long

	suspend fun getAllCharacters() : List<CharacterCacheEntity>

	suspend fun getCharacter(id: Int?): CharacterCacheEntity

	suspend fun getCharacterWithName(name: String): CharacterCacheEntity

	suspend fun update(characterCache: CharacterCacheEntity)

	suspend fun numCharacters(): Int

	suspend fun deleteCache()
}
