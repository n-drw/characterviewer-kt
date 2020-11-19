package cab.andrew.simpsonsview

object Versions {
	const val ktlint = "0.37.2"
}

object Libs {
	const val androidGradlePlugin = "com.android.tools.build:gradle:4.2.0-alpha09"

	const val koinAndroid = "org.koin:koin-android:2.2.0"
	const val koinAndroidX = "org.koin:koin-androidx-scope:2.2.0"
	const val koinAndroidXViewModel = "org.koin:koin-androidx-viewmodel:2.2.0"
	const val koinAndroidXFragment = "org.koin:koin-androidx-fragment:2.2.0"

	const val gradlePlayPublisher = "com.github.triplet.gradle:play-publisher:3.1.0-SNAPSHOT"

	const val threeTenBp = "org.threeten:threetenbp:1.4.4"
	const val threeTenBpNoTzdb = "$threeTenBp:no-tzdb"
	const val threeTenAbp = "com.jakewharton.threetenabp:threetenabp:1.2.4"

	const val gravitySnapHelper = "com.github.rubensousa:gravitysnaphelper:2.2.1"

	const val timber = "com.jakewharton.timber:timber:4.7.1"

	const val glideCompiler = "com.github.bumptech.glide:compiler:4.11.0"
	const val glide = "com.github.bumptech.glide:glide:4.11.0"

	/**
	 * Using Jitpack until AndroidX migration is out.
	 * See https://github.com/openid/AppAuth-Android/pull/508
	 *
	 * https://jitpack.io/#openid/AppAuth-Android
	 */
	const val appauth = "com.github.openid:AppAuth-Android:master-SNAPSHOT"

	const val junit = "junit:junit:4.13"
	const val robolectric = "org.robolectric:robolectric:4.3.1"
	const val mockK = "io.mockk:mockk:1.10.0"

	const val leakCanary = "com.squareup.leakcanary:leakcanary-android:2.4"

	const val moshi = "com.squareup.moshi:moshi:1.11.0"
	const val moshiKt = "com.squareup.moshi:moshi-kotlin:1.11.0"

	const val store = "com.dropbox.mobile.store:store4:4.0.0-alpha07"

	object Insetter {
		private const val version = "0.3.1"
		const val dbx = "dev.chrisbanes:insetter-dbx:$version"
		const val ktx = "dev.chrisbanes:insetter-ktx:$version"
	}

	object Mdc {
		const val material = "com.google.android.material:material:1.1.0"
	}

	object Google {
		const val firebaseCore = "com.google.firebase:firebase-core:17.4.3"

		const val crashlytics = "com.google.firebase:firebase-crashlytics:17.0.1"
		const val crashlyticsGradle = "com.google.firebase:firebase-crashlytics-gradle:2.1.1"

		const val gmsGoogleServices = "com.google.gms:google-services:4.3.3"

		const val openSourceLicensesPlugin = "com.google.android.gms:oss-licenses-plugin:0.10.2"
		const val openSourceLicensesLibrary =
			"com.google.android.gms:play-services-oss-licenses:17.0.0"
	}

	object Kotlin {
		private const val version = "1.4.0"
		const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
		const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
		const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
	}

	object Coroutines {
		private const val version = "1.3.9"
		const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
		const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
		const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
	}

	object AndroidX {
		const val appcompat = "androidx.appcompat:appcompat:1.3.0-alpha01"
		const val browser = "androidx.browser:browser:1.0.0"
		const val collection = "androidx.collection:collection-ktx:1.1.0"
		const val palette = "androidx.palette:palette:1.0.0"
		const val recyclerview = "androidx.recyclerview:recyclerview:1.2.0-alpha05"
		const val emoji = "androidx.emoji:emoji:1.1.0"
		const val swiperefresh = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0-rc01"

		object Navigation {
			private const val version = "2.3.0"
			const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
			const val ui = "androidx.navigation:navigation-ui-ktx:$version"
			const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
		}

		object Fragment {
			private const val version = "1.3.0-alpha08"
			const val fragment = "androidx.fragment:fragment:$version"
			const val fragmentKtx = "androidx.fragment:fragment-ktx:$version"
		}

		object Test {
			private const val version = "1.2.0"
			const val core = "androidx.test:core:$version"
			const val rules = "androidx.test:rules:$version"

			object Ext {
				private const val version = "1.1.2-rc01"
				const val junit = "androidx.test.ext:junit-ktx:$version"
			}

			const val espressoCore = "androidx.test.espresso:espresso-core:3.2.0"
		}

		const val archCoreTesting = "androidx.arch.core:core-testing:2.1.0"

		object Paging {
			private const val version = "2.1.2"
			const val common = "androidx.paging:paging-common-ktx:$version"
			const val runtime = "androidx.paging:paging-runtime-ktx:$version"
		}

		const val preference = "androidx.preference:preference:1.1.1"

		const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.0.0-rc1"

		const val coreKtx = "androidx.core:core-ktx:1.5.0-alpha02"

		object Lifecycle {
			private const val version = "2.3.0-beta01"
			const val extensions = "androidx.lifecycle:lifecycle-extensions:$version"
			const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
			const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
		}

		object Room {
			private const val version = "2.1.0"
			const val common = "androidx.room:room-common:$version"
			const val runtime = "androidx.room:room-runtime:$version"
			const val compiler = "androidx.room:room-compiler:$version"
			const val ktx = "androidx.room:room-ktx:$version"
			const val testing = "androidx.room:room-testing:$version"
		}

		object Work {
			private const val version = "2.4.0"
			const val runtimeKtx = "androidx.work:work-runtime-ktx:$version"
		}

		object Compose {
			const val snapshot = "6765009"
			const val version = "1.0.0-SNAPSHOT"

			@get:JvmStatic
			val snapshotUrl: String
				get() = "https://androidx.dev/snapshots/builds/$snapshot/artifacts/ui/repository/"

			const val runtime = "androidx.compose.runtime:runtime:$version"
			const val livedata = "androidx.compose.runtime:runtime-livedata:${version}"

			const val foundation = "androidx.compose.foundation:foundation:${version}"
			const val layout = "androidx.compose.foundation:foundation-layout:${version}"

			const val ui = "androidx.compose.ui:ui:${version}"
			const val material = "androidx.compose.material:material:${version}"

			const val animation = "androidx.compose.animation:animation:${version}"

			const val tooling = "androidx.ui:ui-tooling:${version}"
			const val test = "androidx.ui:ui-test:${version}"
		}

		object Hilt {
			private const val version = "1.0.0-alpha02"
			const val work = "androidx.hilt:hilt-work:$version"
			const val viewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:$version"
			const val compiler = "androidx.hilt:hilt-compiler:$version"
		}
	}

	object Dagger {
		private const val version = "2.28.3"
		const val dagger = "com.google.dagger:dagger:$version"
		const val compiler = "com.google.dagger:dagger-compiler:$version"
	}

	object Hilt {
		private const val version = "2.28.3-alpha"
		const val library = "com.google.dagger:hilt-android:$version"
		const val compiler = "com.google.dagger:hilt-android-compiler:$version"
		const val testing = "com.google.dagger:hilt-android-testing:$version"
		const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
	}

	object Retrofit {
		private const val version = "2.9.0"
		const val retrofit = "com.squareup.retrofit2:retrofit:$version"
		const val moshiConverter = "com.squareup.retrofit2:converter-moshi:$version"
	}

	object OkHttp {
		private const val version = "4.8.0"
		const val okhttp = "com.squareup.okhttp3:okhttp:$version"
		const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
	}

	object AssistedInject {
		private const val version = "0.5.2"
		const val annotationDagger2 =
			"com.squareup.inject:assisted-inject-annotations-dagger2:$version"
		const val processorDagger2 =
			"com.squareup.inject:assisted-inject-processor-dagger2:$version"
	}
}
