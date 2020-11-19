package cab.andrew.data.cache

import cab.andrew.data.models.Character

interface CacheDataSource {
	suspend fun insert(character: Character): Long

	suspend fun insertList(characters: List<Character>?)

	suspend fun getAllCharacters(): List<Character>

	suspend fun getCharacterWithName(name: String): Character

	suspend fun getCharacter(id: Int?): Character

	suspend fun deleteCache()
}
