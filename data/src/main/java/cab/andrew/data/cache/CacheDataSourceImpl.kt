package cab.andrew.data.cache

import cab.andrew.data.daos.CharacterDaoService
import cab.andrew.data.mappers.CacheMapper
import cab.andrew.data.models.Character

class CacheDataSourceImpl
constructor(
	private val characterDaoService: CharacterDaoService,
	private val cacheMapper: CacheMapper
): CacheDataSource {
	override suspend fun insert(character: Character): Long {
		return characterDaoService.insert(cacheMapper.mapToEntity(character))
	}

	override suspend fun insertList(characters: List<Character>?) {
		if (characters != null) {
			for(character in characters) {
				characterDaoService.insert(cacheMapper.mapToEntity(character))
			}
		}
	}

	override suspend fun getAllCharacters(): List<Character> {
		return cacheMapper.mapFromEntityList(characterDaoService.getAllCharacters())
	}

	override suspend fun getCharacterWithName(name: String): Character {
		return cacheMapper.mapFromEntity(characterDaoService.getCharacterWithName(name))
	}

	override suspend fun getCharacter(id: Int?): Character {
		return cacheMapper.mapFromEntity(characterDaoService.getCharacter(id))
	}

	override suspend fun deleteCache() {
		return characterDaoService.deleteCache()
	}

}
