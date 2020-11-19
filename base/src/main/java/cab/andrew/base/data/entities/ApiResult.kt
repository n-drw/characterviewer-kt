package cab.andrew.base.data.entities

sealed class ApiResult<out R> {
	open fun get(): R? = null
	fun getOrThrow(): R = when (this) {
		is Success -> get()
		is Error -> throw IllegalArgumentException(exception)
	}

}
data class Success<out T>(val data: T) : ApiResult<T>() {
	override fun get(): T = data
}
data class Error(val exception: Exception) : ApiResult<Nothing>()
