package cab.andrew.data.mappers

interface EntityMapper<Entity, DomainModel> {
	fun mapFromEntity(entity: Entity): DomainModel

	fun mapToEntity(domainModel: DomainModel): Entity
}
