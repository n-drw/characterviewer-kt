package cab.andrew.simpsonsview.home

import android.app.Application
import cab.andrew.simpsonsview.home.di.AppModule
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

@HiltAndroidApp
class MainApplication : Application() {
	override fun onCreate() {
		super.onCreate()
	}
}
