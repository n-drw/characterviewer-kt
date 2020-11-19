package cab.andrew.ui_discover

import android.os.Bundle
import androidx.navigation.NavDirections

class DiscoveryFragmentDirections private constructor() {
	private data class ActionDiscoverFragmentToDetailFragment(
			val name: String
	) : NavDirections {
		override fun getActionId(): Int  = R.id.action_discoverFragment_to_detail_navigation

		override fun getArguments(): Bundle {
			val result = Bundle()
			result.putString("name", this.name)
			return result
		}
	}

	companion object {
		fun actionDiscoverFragmentToDetailFragment(name: String): NavDirections =
				ActionDiscoverFragmentToDetailFragment(name)
	}
}
