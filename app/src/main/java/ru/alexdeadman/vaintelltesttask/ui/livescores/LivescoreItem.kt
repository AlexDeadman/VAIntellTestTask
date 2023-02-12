package ru.alexdeadman.vaintelltesttask.ui.livescores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.findFragment
import androidx.navigation.findNavController
import coil.load
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import ru.alexdeadman.vaintelltesttask.R
import ru.alexdeadman.vaintelltesttask.data.soccers.retrofit.livescores.Data
import ru.alexdeadman.vaintelltesttask.databinding.ItemLivescoreBinding
import ru.alexdeadman.vaintelltesttask.showToast

class LivescoreItem(
    private val livescoreData: Data
) : AbstractBindingItem<ItemLivescoreBinding>() {

    override val type: Int
        get() = R.id.item_livescore_id

    override var identifier: Long
        get() = livescoreData.hashCode().toLong()
        set(value) {
            super.identifier = value
        }

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): ItemLivescoreBinding =
        ItemLivescoreBinding.inflate(inflater, parent, false)

    override fun bindView(binding: ItemLivescoreBinding, payloads: List<Any>) {
        binding.apply {
            listOf(
                imageViewHome to livescoreData.teams?.home?.img,
                imageViewAway to livescoreData.teams?.away?.img
            ).forEach { pair ->
                pair.first.load(pair.second) {
                    crossfade(true)
                    R.drawable.question_mark_gradient.let {
                        placeholder(it)
                        error(it)
                    }
                }
            }

            listOf(
                textViewLeague to livescoreData.league?.name,
                textViewHome to livescoreData.teams?.home?.name,
                textViewHomeScore to livescoreData.scores?.homeScore,
                textViewAway to livescoreData.teams?.away?.name,
                textViewAwayScore to livescoreData.scores?.awayScore,
                textViewStatus to livescoreData.statusName,
                textViewTime to livescoreData.time?.minute,
            ).onEach {
                it.first.text = it.second ?: "-"
            }

            // TODO move onClick methods to fragment

            imageButtonNotification.setOnClickListener { view ->
                view.findFragment<LivescoresFragment>().showToast(R.string.not_implemented)
            }

            imageButtonPlay.setOnClickListener { view ->
                val query = listOf(
                    textViewLeague,
                    textViewHome,
                    textViewAway
                ).joinToString("+") { it.text }

                view.findNavController().navigate(
                    R.id.action_LivescoresFragment_to_WebViewFragment,
                    bundleOf(QUERY_BUNDLE_KEY to query)
                )
            }
        }
    }

    companion object {
        const val QUERY_BUNDLE_KEY = "query_bundle_key"
    }
}