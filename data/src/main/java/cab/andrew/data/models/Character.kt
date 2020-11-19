package cab.andrew.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Character(
	val id: Int? = 0,
	@Json(name = "Text")
	val text: String,
	@Json(name = "Icon")
	val icon: Icon
)
