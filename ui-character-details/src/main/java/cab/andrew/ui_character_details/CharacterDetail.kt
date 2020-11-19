package cab.andrew.ui_character_details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import cab.andrew.base.data.entities.Error
import cab.andrew.base.data.entities.Success
import cab.andrew.data.models.Character
import cab.andrew.ui_character_details.databinding.CharacterDetailFragmentBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

private const val TAG = "CharacterDetail"
@AndroidEntryPoint
class CharacterDetail : Fragment() {
	private val detailViewModel: CharacterDetailViewModel by viewModels()
	private lateinit var binding: CharacterDetailFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
		val binding = DataBindingUtil.inflate<cab.andrew.ui_character_details.databinding.CharacterDetailFragmentBinding>(inflater, R.layout.character_detail_fragment, container, false).apply {
			lifecycleOwner = viewLifecycleOwner
			viewModel = detailViewModel
		}
		arguments?.getString("name")
				.let {
					if (it != null) {
						detailViewModel.setStateEvent(CharacterDetailStateEvent.GetCharacterEvent, it)
					}
				}
		detailViewModel.character.observe(viewLifecycleOwner, Observer { dataState ->
			when (dataState) {
				is Success<Character> -> {
					val character = dataState.data
					val delimiter = character.text.indexOf(" - ")
					val charName = character.text.substring(0, delimiter)
					val charDescription = character.text.substring(delimiter)
					val imgUrl = character.icon.url
					val imgSrc = "http://api.duckduckgo.com$imgUrl"
					Glide.with(binding.root)
							.load(imgSrc)
							.centerCrop()
							.apply(RequestOptions.circleCropTransform())
							.placeholder(R.drawable.ic_image_not_found)
							.into(binding.characterDetailImage)
					binding.detailName.text = charName
					binding.detailDescription.text = charDescription
					Log.d(TAG, "data " + dataState.data)
				}
				is Error -> {
					Log.d(TAG, "data " + dataState.exception)
				}
			}
		})
		return binding.root
    }

}

