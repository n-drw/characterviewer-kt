package cab.andrew.simpsonsview.home.di

import android.content.Context
import android.view.LayoutInflater
import androidx.room.Room
import cab.andrew.data.models.Character
import cab.andrew.data.CharacterDatabase
import cab.andrew.data.cache.CacheDataSource
import cab.andrew.data.cache.CacheDataSourceImpl
import cab.andrew.data.daos.CharacterDao
import cab.andrew.data.daos.CharacterDaoImpl
import cab.andrew.data.daos.CharacterDaoService
import cab.andrew.data.entities.CharacterCacheEntity
import cab.andrew.data.mappers.CacheMapper
import cab.andrew.data.mappers.EntityMapper
import cab.andrew.data.mappers.NetworkMapper
import cab.andrew.data.repositories.characters.*
import cab.andrew.data.utils.Converters
import cab.andrew.simpsonsview.BuildConfig
import cab.andrew.ui_character_details.GetUserDetailUseCase
import cab.andrew.ui_character_details.databinding.CharacterDetailFragmentBinding
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object AppModule {
	const val URL = "http://api.duckduckgo.com"

	@Singleton
	@Provides
	fun provideCacheMapper(): EntityMapper<CharacterCacheEntity, Character> {
		return CacheMapper()
	}

	@Singleton
	@Provides
	fun provideCharacterDb(@ApplicationContext context: Context): CharacterDatabase {
		return Room
			.databaseBuilder(
				context,
				CharacterDatabase::class.java,
				CharacterDatabase.DATABASE_NAME
			)
			.fallbackToDestructiveMigration()
			.build()
	}

	@Singleton
	@Provides
	fun provideCharacterDao(characterDatabase: CharacterDatabase): CharacterDao {
		return characterDatabase.characterDao()
	}

	@Singleton
	@Provides
	fun provideCharacterDaoService(characterDao: CharacterDao): CharacterDaoService {
		return CharacterDaoImpl(characterDao)
	}

	@Singleton
	@Provides
	fun provideCacheDataSource(
		characterDaoService: CharacterDaoService,
		cacheMapper: CacheMapper
	): CacheDataSource{
		return CacheDataSourceImpl(characterDaoService, cacheMapper)
	}

	@Singleton
	@Provides
	fun provideCharacterService(
		retrofit: Retrofit.Builder
	): CharacterService {
		return retrofit
			.build()
			.create(CharacterService::class.java)
	}

	@Singleton
	@Provides
	fun provideRetrofitService(
		characterService: CharacterService
	): CharacterRetrofitService {
		return CharacterServiceImpl(characterService)
	}

	@Provides
	@Singleton
	fun provideKotlinJsonAdapter() : KotlinJsonAdapterFactory {
		return KotlinJsonAdapterFactory()
	}

	@Provides
	@Singleton
	fun provideMoshi(kotlinJsonAdapterFactory: KotlinJsonAdapterFactory) : Moshi {
		return Moshi.Builder()
			.add(kotlinJsonAdapterFactory)
			.build()
	}

	@Provides
	@Singleton
	fun provideOkHttp(): OkHttpClient {
		return OkHttpClient
			.Builder()
			.build()
	}

	@Provides
	@Singleton
	fun provideRetrofitClient(
		okHttp: OkHttpClient,
		moshi: Moshi
	): Retrofit.Builder {
		return Retrofit.Builder()
			.client(okHttp)
			.baseUrl(BuildConfig.URL)
			.addConverterFactory(MoshiConverterFactory.create(moshi))
	}

	@Provides
	@Singleton
	fun provideUserDetails(repository: CharacterRepository): GetUserDetailUseCase {
		return GetUserDetailUseCase(repository)
	}


	@Provides
	@Singleton
	fun provideNavArgsForDetailView(): String {
		return String()
	}
}
