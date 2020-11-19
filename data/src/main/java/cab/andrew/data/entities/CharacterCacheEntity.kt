package cab.andrew.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import cab.andrew.data.models.Icon
import cab.andrew.data.utils.Converters
import com.squareup.moshi.JsonClass

@Entity(tableName = "characters")
@JsonClass(generateAdapter = true)
@TypeConverters(Converters::class)
data class CharacterCacheEntity(
	@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0,
	@ColumnInfo(name = "description") val text: String,
	@ColumnInfo(name = "image")  val icon: Icon,
)
