package cab.andrew.data.utils

import android.text.TextUtils
import androidx.room.TypeConverter
import cab.andrew.data.models.Icon
import com.squareup.moshi.*
import java.lang.reflect.ParameterizedType

class Converters {

	private val moshi = Moshi.Builder().build()

	@TypeConverter
	fun fromJson(string: String): Icon? {
		if (TextUtils.isEmpty(string))
			return null

		val jsonAdapter = moshi.adapter(Icon::class.java)
		return jsonAdapter.fromJson(string)
	}

	@TypeConverter
	fun toJson(icon: Icon): String {
		val jsonAdapter = moshi.adapter(Icon::class.java)
		return jsonAdapter.toJson(icon)
	}
}
