package cab.andrew.ui_discover.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import cab.andrew.data.models.Character
import cab.andrew.ui_discover.DiscoverViewModel
import cab.andrew.ui_discover.databinding.ItemCharacterBinding

class DiscoverAdapter(private val viewModel: DiscoverViewModel, private val listener: CharacterItemListener) : RecyclerView.Adapter<DiscoverViewHolder>(), Filterable {
	private val characters: MutableList<Character> = mutableListOf()
	private val characterFull: MutableList<Character> = mutableListOf()

	interface CharacterItemListener {
		fun onClickedCharacter(characterText: String)
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscoverViewHolder {
		val binding: ItemCharacterBinding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return DiscoverViewHolder(binding, listener)
	}

	override fun onBindViewHolder(holder: DiscoverViewHolder, position: Int) {
		holder.bind(characters[position], viewModel)
	}

	override fun getItemCount(): Int
			= characters.size

	fun updateData(items: List<Character>) {
		val diffCallback = DiscoverItemDiffCallback(characters, items)
		val diffResult = DiffUtil.calculateDiff(diffCallback)

		characters.clear()
		characters.addAll(items)
		characterFull.addAll(characters)
		diffResult.dispatchUpdatesTo(this)
	}

	override fun getFilter(): Filter {
		return object : Filter() {
			override fun performFiltering(constraint: CharSequence?): FilterResults {
				val filteredCharacters: MutableList<Character> = mutableListOf()
				val query = constraint.toString().toLowerCase()

				if (query.isEmpty()) {
					filteredCharacters.addAll(characterFull)
				} else {
					characters.forEach {
						if (it.text.toLowerCase().contains(query)){
							filteredCharacters.add(it)
						}
					}
				}

				val filterResults = Filter.FilterResults()
				filterResults.values = filteredCharacters
				return filterResults
			}

			override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
				characters.clear()
				@Suppress("UNCHECKED_CAST")
				characters.addAll(results?.values as Collection<Character>)
				notifyDataSetChanged()
			}

		}
	}
}





