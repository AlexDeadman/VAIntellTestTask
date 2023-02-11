package ru.alexdeadman.vaintelltesttask.ui.livescores

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.diff.FastAdapterDiffUtil
import dagger.hilt.android.AndroidEntryPoint
import ru.alexdeadman.vaintelltesttask.R
import ru.alexdeadman.vaintelltesttask.collectOnLifecycle
import ru.alexdeadman.vaintelltesttask.databinding.FragmentLivescoresBinding
import ru.alexdeadman.vaintelltesttask.showToast

@AndroidEntryPoint
class LivescoresFragment : Fragment() {

    private var _binding: FragmentLivescoresBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLivescoresBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemAdapter = ItemAdapter<LivescoreItem>()
        val fastAdapter = FastAdapter.with(itemAdapter)

        binding.recycleView.apply {
            setHasFixedSize(true)
            adapter = fastAdapter
        }

        val livescoresViewModel: LivescoresViewModel by viewModels()

        livescoresViewModel.livescoresStateFlow
            .collectOnLifecycle(
                viewLifecycleOwner,
                Lifecycle.State.STARTED
            ) { state ->
                when (state) {
                    LivescoresState.Default -> {}
                    LivescoresState.Loading -> {}
                    is LivescoresState.Loaded -> {
                        FastAdapterDiffUtil[itemAdapter] =
                            state.result.data.map { LivescoreItem(it) }
                    }
                    is LivescoresState.Error -> {
                        showToast(R.string.unknown_error) // TODO temp
                    }
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}