package cab.andrew.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterWrapper(
	val relatedTopics: List<Character>
)
