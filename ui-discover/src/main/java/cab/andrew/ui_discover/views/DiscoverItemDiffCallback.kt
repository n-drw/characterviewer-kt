package cab.andrew.ui_discover.views

import androidx.recyclerview.widget.DiffUtil
import cab.andrew.data.models.Character

class DiscoverItemDiffCallback(private val oldList: List<Character>,
						   private val newList: List<Character>) : DiffUtil.Callback() {

	override fun getOldListSize() = oldList.size

	override fun getNewListSize() = newList.size

	override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int)
			= oldList[oldItemPosition] == newList[newItemPosition]

	override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
		return oldList[oldItemPosition].text == newList[newItemPosition].text
				&& oldList[oldItemPosition].icon == newList[newItemPosition].icon
	}
}
