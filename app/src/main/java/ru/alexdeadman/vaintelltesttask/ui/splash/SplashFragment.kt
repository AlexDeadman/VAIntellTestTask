package ru.alexdeadman.vaintelltesttask.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.alexdeadman.vaintelltesttask.R
import ru.alexdeadman.vaintelltesttask.collectOnLifecycle
import ru.alexdeadman.vaintelltesttask.databinding.FragmentSplashBinding
import ru.alexdeadman.vaintelltesttask.ui.livescores.LivescoresState
import ru.alexdeadman.vaintelltesttask.ui.livescores.LivescoresViewModel

@AndroidEntryPoint
class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    private val livescoresViewModel: LivescoresViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        livescoresViewModel.livescoresStateFlow
            .collectOnLifecycle(
                viewLifecycleOwner,
                Lifecycle.State.STARTED
            ) { state ->
                if (state is LivescoresState.Loaded || state is LivescoresState.Error) {
                    findNavController().navigate(R.id.action_SplashFragment_to_MainFragment)
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}