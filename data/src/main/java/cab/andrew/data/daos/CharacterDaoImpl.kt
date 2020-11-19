package cab.andrew.data.daos

import cab.andrew.data.entities.CharacterCacheEntity
import cab.andrew.data.mappers.CacheMapper

class CharacterDaoImpl
constructor(
	private val characterDao: CharacterDao,
): CharacterDaoService {
	override suspend fun getAllCharacters(): List<CharacterCacheEntity> {
		return characterDao.getAllCharacters()
	}

	override suspend fun getCharacter(id: Int?): CharacterCacheEntity {
		return characterDao.getCharacter(id)
	}

	override suspend fun getCharacterWithName(name: String): CharacterCacheEntity {
		return characterDao.getCharacterWithName(name)
	}

	override suspend fun insertAll(characterCaches: List<CharacterCacheEntity>) {
		return characterDao.insertAll(characterCaches)
	}

	override suspend fun insert(characterCache: CharacterCacheEntity): Long {
		return characterDao.insert(characterCache)
	}

	override suspend fun update(characterCache: CharacterCacheEntity) {
		return characterDao.update(characterCache)
	}

	override suspend fun numCharacters(): Int {
		return characterDao.numCharacters()
	}

	override suspend fun deleteCache() {
		return characterDao.deleteCache()
	}
}
