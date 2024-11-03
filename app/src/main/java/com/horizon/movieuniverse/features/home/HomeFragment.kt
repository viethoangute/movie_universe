package com.horizon.movieuniverse.features.home

import android.annotation.SuppressLint
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.horizon.movieuniverse.databinding.FragmentHomeBinding
import com.horizon.movieuniverse.features.home.adapter.SliderAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.abs

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var sliderAdapter: SliderAdapter

    private val viewModel: HomeViewModel by viewModels()
    private val compositePageTransformer by lazy {
        CompositePageTransformer().apply {
            addTransformer(MarginPageTransformer(40))
            addTransformer { page, position ->
                val absPos = abs(position)
                if (position <= 0) {
                    page.scaleY = 1 - absPos * 0.15f
                } else {
                    page.scaleY = 1 - absPos * 0.15f
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()

        viewModel.sliderItems.observe(viewLifecycleOwner) { items ->
            with(binding) {
                if (items.isNotEmpty()) {
                    sliderAdapter = SliderAdapter(items)
                    sliderMovies.visibility = View.VISIBLE
                    sliderMovies.adapter = sliderAdapter
                    sliderMovies.setPageTransformer(compositePageTransformer)
                    sliderMovies.currentItem = items.size / 2
                } else {
                    sliderMovies.visibility = View.GONE
                }
            }
        }
        viewModel.fetchListSlider()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initViews() {
        with(binding) {
            sliderAdapter = SliderAdapter(listOf())
            sliderMovies.clipToPadding = false
            sliderMovies.clipChildren = false
            sliderMovies.offscreenPageLimit = 3
            sliderMovies.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            sliderMovies.adapter = sliderAdapter
            sliderMovies.setPageTransformer(compositePageTransformer)
        }
    }
}