package cab.andrew.data.mappers

import cab.andrew.data.models.Character
import cab.andrew.data.entities.CharacterCacheEntity
import javax.inject.Inject

class CacheMapper
@Inject
constructor(): EntityMapper<CharacterCacheEntity, Character> {
	override fun mapFromEntity(entity: CharacterCacheEntity): Character {
		return Character(
			id = entity.id,
			text = entity.text,
			icon = entity.icon
		)
	}

	override fun mapToEntity(domainModel: Character): CharacterCacheEntity {
		return CharacterCacheEntity(
				text = domainModel.text,
				icon = domainModel.icon
		)
	}

	fun mapFromEntityList(entities: List<CharacterCacheEntity>): List<Character> {
		return entities.map { mapFromEntity(it) }
	}
}
