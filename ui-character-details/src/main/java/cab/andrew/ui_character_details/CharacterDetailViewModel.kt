package cab.andrew.ui_character_details

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import cab.andrew.base.data.entities.ApiResult
import cab.andrew.data.cache.CacheDataSource
import cab.andrew.data.daos.CharacterDao
import cab.andrew.data.models.Character
import cab.andrew.data.repositories.characters.CharacterRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.onEach
import kotlin.coroutines.CoroutineContext

private const val TAG = "CharacterDetailViewMode"
class CharacterDetailViewModel @ViewModelInject constructor(
	private val repository: CharacterRepository,
	private val getUserDetailUseCase: GetUserDetailUseCase
) : ViewModel() {
	private var characterSource: LiveData<ApiResult<Character>> = MutableLiveData()
	private val _character = MediatorLiveData<ApiResult<Character>>()
	val character: LiveData<ApiResult<Character>> get() = _character



	fun setStateEvent(characterDetailStateEvent: CharacterDetailStateEvent, detailArgs: String)	{
		viewModelScope.launch {
			when(characterDetailStateEvent) {
				is CharacterDetailStateEvent.GetCharacterEvent -> {
					_character.removeSource(characterSource)
					withContext (coroutineContext) {
						characterSource = repository.getCharacterDetailWithCache(detailArgs)
					}
					_character.addSource(characterSource) {
						_character.value = it
					}
				}
			}
		}
	}
}

sealed class CharacterDetailStateEvent() {
	object GetCharacterEvent: CharacterDetailStateEvent()
}

