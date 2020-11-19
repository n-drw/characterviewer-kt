package cab.andrew.data.entities

import androidx.annotation.Nullable
import cab.andrew.data.models.Character
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import retrofit2.Response

@JsonClass(generateAdapter = true)
data class CharacterWrapperNetworkEntity (
	@Json(name = "RelatedTopics")
	val relatedTopics: List<CharacterNetworkEntity>
)
