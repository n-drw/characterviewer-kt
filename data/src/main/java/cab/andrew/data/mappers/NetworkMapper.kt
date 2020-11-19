package cab.andrew.data.mappers

import cab.andrew.data.models.Character
import cab.andrew.data.entities.CharacterNetworkEntity
import retrofit2.Response
import javax.inject.Inject

class NetworkMapper
@Inject
constructor(): EntityMapper<CharacterNetworkEntity, Character> {

	override fun mapFromEntity(entity: CharacterNetworkEntity): Character {
		return Character(
				text = entity.text,
				icon = entity.icon
		)
	}

	override fun mapToEntity(domainModel: Character): CharacterNetworkEntity {
		return CharacterNetworkEntity(
				text = domainModel.text,
				icon = domainModel.icon
		)
	}

	fun mapFromEntityList(entities: List<CharacterNetworkEntity>?): List<Character>? {
		return entities?.map { mapFromEntity(it) }
	}
}

