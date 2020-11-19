package cab.andrew.data.repositories.characters

import cab.andrew.base.data.entities.ApiResult
import cab.andrew.data.models.CharacterWrapper
import cab.andrew.data.entities.CharacterCacheEntity
import cab.andrew.data.entities.CharacterNetworkEntity

interface NetworkDataSource {
	suspend fun getAllCharacters(): CharacterWrapper
}
