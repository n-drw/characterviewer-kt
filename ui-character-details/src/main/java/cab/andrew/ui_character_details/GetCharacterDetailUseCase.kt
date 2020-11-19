package cab.andrew.ui_character_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import cab.andrew.base.data.entities.ApiResult
import cab.andrew.data.models.Character
import cab.andrew.data.repositories.characters.CharacterRepository

class GetUserDetailUseCase(private val repository: CharacterRepository) {

	suspend operator fun invoke(name: String): LiveData<ApiResult<Character>> {
		return Transformations.map(repository.getCharacterDetailWithCache(name)) {
			it
		}
	}
}
