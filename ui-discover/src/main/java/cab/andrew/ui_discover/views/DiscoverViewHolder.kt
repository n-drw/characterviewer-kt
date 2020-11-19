package cab.andrew.ui_discover.views

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import cab.andrew.data.models.Character
import cab.andrew.ui_discover.DiscoverViewModel
import cab.andrew.ui_discover.R
import cab.andrew.ui_discover.databinding.ItemCharacterBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

private const val TAG = "DiscoverViewHolder"
class DiscoverViewHolder(private val binding: ItemCharacterBinding, private val listener: DiscoverAdapter.CharacterItemListener): RecyclerView.ViewHolder(binding.root), View.OnClickListener {
	private lateinit var character: Character

	init {
		binding.root.setOnClickListener(this)
	}

	fun bind(item: Character, viewModel: DiscoverViewModel) {
		val charName = item.text.substringBefore(" - ")
		val imgUrl = item.icon.url
		val imgSrc = "http://api.duckduckgo.com$imgUrl"
		Glide.with(binding.root)
			.load(imgSrc)
			.centerCrop()
			.apply(RequestOptions.circleCropTransform())
			.placeholder(R.drawable.ic_image_not_found)
			.into(binding.listIcon)

		this.character = item
		binding.characterName.text =  charName
		binding.viewmodel = viewModel
	}

	override fun onClick(v: View?) {
		listener.onClickedCharacter(character.text)
	}
}
