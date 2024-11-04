package com.horizon.movieuniverse.features.home.view

import android.annotation.SuppressLint
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.horizon.movieuniverse.databinding.FragmentHomeBinding
import com.horizon.movieuniverse.features.home.adapter.MovieInCategoryAdapter
import com.horizon.movieuniverse.features.home.viewmodel.HomeViewModel
import com.horizon.movieuniverse.features.home.adapter.SliderAdapter
import com.horizon.movieuniverse.features.home.viewmodel.HomeViewModel.Companion.HOAT_HINH
import com.horizon.movieuniverse.features.home.viewmodel.HomeViewModel.Companion.PHIM_BO
import com.horizon.movieuniverse.features.home.viewmodel.HomeViewModel.Companion.PHIM_LE
import com.horizon.movieuniverse.features.home.viewmodel.HomeViewModel.Companion.TV_SHOWS
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
        initRecentlyAddedMovies()
        initMoviesByCategory()
    }

    private fun initRecentlyAddedMovies() {
        viewModel.sliderItems.observe(viewLifecycleOwner) { items ->
            with(binding) {
                if (items.isNotEmpty()) {
                    sliderAdapter = SliderAdapter(items)
                    sliderMovies.adapter = sliderAdapter
                    sliderMovies.setPageTransformer(compositePageTransformer)
                    sliderMovies.currentItem = items.size / 2
                }
            }
        }
        viewModel.getRecentlyAddedMovies()
    }

    private fun initMoviesByCategory() {
        with(binding) {
            rcvPhimLe.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            rcvPhimBo.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            rcvHoatHinh.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            rcvTvShows.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

            viewModel.phimLe.observe(viewLifecycleOwner) { movies ->
                if (movies.isNotEmpty()) {
                    tvPhimLe.visibility = View.VISIBLE
                    rcvPhimLe.visibility = View.VISIBLE
                    rcvPhimLe.adapter = MovieInCategoryAdapter(movies)
                }
            }
            viewModel.getMoviesByCategory(PHIM_LE)

            viewModel.phimBo.observe(viewLifecycleOwner) { movies ->
                if (movies.isNotEmpty()) {
                    tvPhimBo.visibility = View.VISIBLE
                    rcvPhimBo.visibility = View.VISIBLE
                    rcvPhimBo.adapter = MovieInCategoryAdapter(movies)
                }
            }
            viewModel.getMoviesByCategory(PHIM_BO)

            viewModel.hoatHinh.observe(viewLifecycleOwner) { movies ->
                if (movies.isNotEmpty()) {
                    tvHoatHinh.visibility = View.VISIBLE
                    rcvHoatHinh.visibility = View.VISIBLE
                    rcvHoatHinh.adapter = MovieInCategoryAdapter(movies)
                }
            }
            viewModel.getMoviesByCategory(HOAT_HINH)

            viewModel.tvShows.observe(viewLifecycleOwner) { movies ->
                if (movies.isNotEmpty()) {
                    tvTvShows.visibility = View.VISIBLE
                    rcvTvShows.visibility = View.VISIBLE
                    rcvTvShows.adapter = MovieInCategoryAdapter(movies)
                }
            }
            viewModel.getMoviesByCategory(TV_SHOWS)
        }
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