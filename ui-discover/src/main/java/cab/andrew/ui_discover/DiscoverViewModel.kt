package cab.andrew.ui_discover

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import cab.andrew.base.data.entities.ApiResult
import cab.andrew.data.models.Character
import cab.andrew.data.repositories.characters.CharacterRepository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

private const val TAG = "DiscoverViewModel"
class DiscoverViewModel @ViewModelInject constructor(
	private val repository: CharacterRepository,
	@Assisted private val savedStateHandle: SavedStateHandle
): ViewModel() {
	private val _characters = MediatorLiveData<ApiResult<List<Character>>>()
	val characters: LiveData<ApiResult<List<Character>>> get () = _characters

	fun setStateEvent(discoverViewStateEvent: DiscoverViewStateEvent) {
		viewModelScope.launch {
			when(discoverViewStateEvent) {
				is DiscoverViewStateEvent.GetCharacterEvents -> {
					repository.getCharacters()
						.onEach {character ->
							_characters.value = character
						}
						.launchIn(viewModelScope)
				}
				is DiscoverViewStateEvent.ClearCache -> {
					_characters.removeSource(characters)
				}
			}
		}
	}

//	fun setQuery(query: String) {
//
//	}
}

sealed class DiscoverViewStateEvent(
		var searchQuery: String? = null
)  {
	object Search: DiscoverViewStateEvent()
	object GetCharacterEvents: DiscoverViewStateEvent()
	object ClearCache : DiscoverViewStateEvent()
}
