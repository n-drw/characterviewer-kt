package cab.andrew.data.repositories.characters

import cab.andrew.data.BuildConfig
import cab.andrew.data.entities.CharacterWrapperNetworkEntity
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import retrofit2.http.Url

interface CharacterService {
//	@GET("/?format=json")
//	suspend fun getAllCharacters(@Query("q") q: String) : List<CharacterWrapperNetworkEntity>

	@GET()
	@Headers("Accept: application/json")
	suspend fun getAllCharacters(@Url url: String = BuildConfig.URL) : Response<CharacterWrapperNetworkEntity>
}
