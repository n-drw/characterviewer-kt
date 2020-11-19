package cab.andrew.data.repositories.characters

import cab.andrew.data.BuildConfig
import cab.andrew.data.models.CharacterWrapper
import cab.andrew.data.entities.CharacterWrapperNetworkEntity
import retrofit2.Response

class CharacterServiceImpl
	constructor(
		private val characterService: CharacterService
	): CharacterRetrofitService {
	override suspend fun getAllCharacters(): Response<CharacterWrapperNetworkEntity> {
		return characterService.getAllCharacters(BuildConfig.URL)
	}
}
