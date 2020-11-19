package cab.andrew.simpsonsview.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import cab.andrew.common_ui_view.gone
import cab.andrew.common_ui_view.visible
import cab.andrew.simpsonsview.R
import cab.andrew.simpsonsview.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import dev.chrisbanes.insetter.Insetter
import dev.chrisbanes.insetter.Side
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "MainActivity"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
	private val appBarConfiguration: AppBarConfiguration by lazy {
		AppBarConfiguration.Builder(setOf(R.id.discoverFragment, R.id.aboutFragment)).build()
	}
	private lateinit var binding: ActivityMainBinding


	override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
		binding.lifecycleOwner = this
		Insetter.builder()
			.applySystemWindowInsetsToPadding(Side.LEFT or Side.RIGHT)
			.consumeSystemWindowInsets(Insetter.CONSUME_AUTO)
			.applyToView(binding.root)

		Insetter.builder()
			.applySystemWindowInsetsToPadding(Side.BOTTOM)
			.consumeSystemWindowInsets(Insetter.CONSUME_AUTO)
			.applyToView(binding.root)

		Insetter.setEdgeToEdgeSystemUiFlags(binding.homeRoot, true)
		initBottomNav(binding)
    }

	private fun initBottomNav(binding: ActivityMainBinding) {
		val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
		val navController = navHostFragment.navController
		binding.apply {
			with(navController) {
//				toolbar.setupWithNavController(navController, appBarConfiguration)
				bottomNav.setupWithNavController(this@with)
				setupActionBarWithNavController(this@with, appBarConfiguration)
				this.addOnDestinationChangedListener { _, destination, _ ->
					when (destination.id) {
						R.id.discoverFragment, R.id.aboutFragment -> bottomNav.visible()
						else -> bottomNav.gone()
					}

				}
			}
		}
	}

}
