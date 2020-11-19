package cab.andrew.ui_discover.views

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import cab.andrew.base.data.entities.ApiResult
import cab.andrew.data.models.Character

@BindingAdapter("bind:items")
fun setItems(recyclerView: RecyclerView, resource: ApiResult<List<Character>>?) {
	with(recyclerView.adapter as DiscoverAdapter) {
		resource?.get()?.let {
			updateData(it)
		}
	}
}
