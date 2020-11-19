package cab.andrew.data.entities

import cab.andrew.data.models.Icon
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterNetworkEntity (
	@Json(name = "Text")
	val text: String,
	@Json(name = "Icon")
	val icon: Icon
)
