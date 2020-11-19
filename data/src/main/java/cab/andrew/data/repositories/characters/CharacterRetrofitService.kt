package cab.andrew.data.repositories.characters

import cab.andrew.data.entities.CharacterWrapperNetworkEntity
import retrofit2.Response


interface CharacterRetrofitService {
	suspend fun getAllCharacters(): Response<CharacterWrapperNetworkEntity>
}
