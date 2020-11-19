package cab.andrew.data.repositories.characters

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import cab.andrew.base.data.entities.ApiResult
import cab.andrew.base.data.entities.Error
import cab.andrew.base.data.entities.Success
import cab.andrew.data.BuildConfig
import cab.andrew.data.cache.CacheDataSource
import cab.andrew.data.models.Character
import cab.andrew.data.models.CharacterWrapper
import cab.andrew.data.daos.CharacterDao
import cab.andrew.data.daos.CharacterDaoService
import cab.andrew.data.entities.CharacterWrapperNetworkEntity
import cab.andrew.data.mappers.CacheMapper
import cab.andrew.data.mappers.NetworkMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
private const val TAG = "CharacterRepository"
class CharacterRepository @Inject constructor(
	private val characterService: CharacterService,
	private val cacheDataSource: CacheDataSource,
	private val networkMapper: NetworkMapper,
	private val characterDao: CharacterDao
) {
	suspend fun getCharacters(): Flow<ApiResult<List<Character>>> = flow {
		try {
			val networkCharacters = characterService.getAllCharacters(BuildConfig.URL)
			val characters = networkMapper.mapFromEntityList(networkCharacters.body()?.relatedTopics)

			cacheDataSource.deleteCache()
			cacheDataSource.insertList(characters)
			val cacheCharacters = cacheDataSource.getAllCharacters()

			emit(Success(cacheCharacters))
		} catch (e: Exception) {
			emit(Error(e))
		}
	}

	suspend fun getCharacterDetailWithCache(name: String): LiveData<ApiResult<Character>> = liveData {
			try {
				val networkCharacters = characterService.getAllCharacters(BuildConfig.URL)
				val characters = networkMapper.mapFromEntityList(networkCharacters.body()?.relatedTopics)
				cacheDataSource.insertList(characters)
				val cacheCharacter = cacheDataSource.getCharacterWithName(name)
				emit(Success(cacheCharacter))
			} catch (e: Exception){
				emit(Error(e))
			}
}

	suspend fun getCharacter(id: Int?): LiveData<ApiResult<Character>> = liveData {
		try {
			val networkCharacters = characterService.getAllCharacters(BuildConfig.URL)
			val characters = networkMapper.mapFromEntityList(networkCharacters.body()?.relatedTopics)
			cacheDataSource.insertList(characters)
			emit(Success(cacheDataSource.getCharacter(id)))
		} catch (e: Exception) {
			emit(Error(e))
		}
	}

	suspend fun clearCacheData() {
		try {
			cacheDataSource.deleteCache()
		} catch (error: Throwable){
		}
	}
}
