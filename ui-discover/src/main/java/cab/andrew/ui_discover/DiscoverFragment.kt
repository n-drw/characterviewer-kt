package cab.andrew.ui_discover

import android.app.SearchManager
import android.app.usage.UsageEvents.Event.NONE
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.SearchView
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import cab.andrew.base.data.entities.Success
import cab.andrew.data.models.Character
import cab.andrew.ui_discover.databinding.DiscoverFragmentBinding
import cab.andrew.ui_discover.views.DiscoverAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.discover_fragment.*

private const val TAG = "DiscoverFragment"
@AndroidEntryPoint
class DiscoverFragment : Fragment(), DiscoverAdapter.CharacterItemListener {
	private val discoverViewModel: DiscoverViewModel by viewModels()
	private lateinit var binding: DiscoverFragmentBinding
	private val adapter by lazy(NONE) { DiscoverAdapter(discoverViewModel, this) }

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		val binding: DiscoverFragmentBinding = DiscoverFragmentBinding.inflate(inflater, container, false). apply {
			viewModel = discoverViewModel
			lifecycleOwner = this@DiscoverFragment
			discoveryRecyclerView.adapter = adapter
		}
		setHasOptionsMenu(true)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		postponeEnterTransition()
		view.doOnPreDraw { startPostponedEnterTransition() }
		discoverViewModel.setStateEvent(DiscoverViewStateEvent.GetCharacterEvents)
		setupSwipeRefresh()
		subscribeObservers()
	}

	private fun setupSwipeRefresh() {
		swipe_refresh.setOnRefreshListener {
			discoverViewModel.setStateEvent(DiscoverViewStateEvent.ClearCache)
			swipe_refresh.isRefreshing = false
		}
	}

	private fun subscribeObservers(){
		discoverViewModel.characters.observe(viewLifecycleOwner, Observer { dataState ->
			when(dataState){
				is Success<List<Character>> -> {
					Log.d(TAG, "data " + dataState.data)
				}
				is Error -> {
					Log.d(TAG, "data " + dataState.message)
				}
			}
		})
	}

	override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
		menuInflater.inflate(R.menu.toolbar_menu, menu)
		val searchItem = menu.findItem(R.id.app_bar_search)
		val searchManager = activity?.getSystemService(Context.SEARCH_SERVICE) as? SearchManager
		val searchView = searchItem.actionView as? SearchView
		searchView?.setSearchableInfo(searchManager?.getSearchableInfo(activity?.componentName))
		searchView?.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
			override fun onQueryTextSubmit(query: String?): Boolean {
				return false
			}

			override fun onQueryTextChange(newText: String?): Boolean {
				adapter.filter.filter(newText)
				return false
			}
		})
		super.onCreateOptionsMenu(menu, menuInflater)
	}

	override fun onClickedCharacter(characterText: String) {
		findNavController().navigate(DiscoveryFragmentDirections.actionDiscoverFragmentToDetailFragment(characterText))
	}

}
