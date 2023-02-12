package ru.alexdeadman.vaintelltesttask.ui.webview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import ru.alexdeadman.vaintelltesttask.databinding.FragmentWebViewBinding
import ru.alexdeadman.vaintelltesttask.ui.livescores.LivescoreItem

class WebViewFragment : Fragment() {

    private var _binding: FragmentWebViewBinding? = null
    private val binding get() = _binding!!

    private var webView: WebView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWebViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webView = binding.root

        webView?.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true // TODO XSS filter required

            val query = requireArguments().getString(LivescoreItem.QUERY_BUNDLE_KEY)
            loadUrl("https://www.google.com/search?q=$query+watch")
        }

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    webView?.let {
                        if (it.canGoBack()) {
                            it.goBack()
                        } else {
                            isEnabled = false
                            requireActivity().onBackPressed()
                        }
                    }
                }
            }
        )
    }

    override fun onResume() {
        super.onResume()
        webView?.run {
            onResume()
            resumeTimers()
        }
    }

    override fun onPause() {
        super.onPause()
        webView?.run {
            onPause()
            pauseTimers()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}