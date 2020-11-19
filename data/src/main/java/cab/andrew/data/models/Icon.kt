package cab.andrew.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Icon (
	@Json(name = "URL")
	val url: String
)
