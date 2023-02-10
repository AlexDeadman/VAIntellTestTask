package ru.alexdeadman.vaintelltesttask.ui.livescores

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import dagger.hilt.android.AndroidEntryPoint
import ru.alexdeadman.vaintelltesttask.R
import ru.alexdeadman.vaintelltesttask.collectOnLifecycle
import ru.alexdeadman.vaintelltesttask.databinding.FragmentMainBinding

@AndroidEntryPoint
class LivescoresFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val livescoresViewModel: LivescoresViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        livescoresViewModel.livescoresStateFlow
            .collectOnLifecycle(
                viewLifecycleOwner,
                Lifecycle.State.STARTED
            ) { state ->
                when(state) {
                    LivescoresState.Default -> {}
                    LivescoresState.Loading -> {}
                    is LivescoresState.Loaded -> {
                        binding.textview.text = state.result.toString()
                    }
                    is LivescoresState.Error -> {
                        binding.textview.setText(R.string.unknown_error) // TODO temp msg
                    }
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}