package ru.alexdeadman.vaintelltesttask.ui.livescores

import android.view.LayoutInflater
import android.view.ViewGroup
import coil.load
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import ru.alexdeadman.vaintelltesttask.R
import ru.alexdeadman.vaintelltesttask.data.soccers.retrofit.livescores.Data
import ru.alexdeadman.vaintelltesttask.databinding.ItemLivescoreBinding

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
                textViewLeague to livescoreData.league?.name,
                textViewHome to livescoreData.teams?.home?.name,
                textViewHomeScore to livescoreData.scores?.homeScore,
                textViewAway to livescoreData.teams?.away?.name,
                textViewAwayScore to livescoreData.scores?.awayScore,
                textViewStatus to livescoreData.statusName,
                textViewTime to livescoreData.time?.minute,
            ).forEach {
                it.first.text = it.second ?: "-"
            }

            listOf(
                imageViewHome to livescoreData.teams?.home?.img,
                imageViewAway to livescoreData.teams?.away?.img
            ). forEach {
                it.first.load(it.second) {
                    crossfade(true)
                    placeholder(R.drawable.question_mark_gradient)
                }
            }
        }
    }
}