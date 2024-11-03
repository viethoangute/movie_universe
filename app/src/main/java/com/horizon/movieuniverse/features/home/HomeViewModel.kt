package com.horizon.movieuniverse.features.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.horizon.movieuniverse.model.SliderItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    val sliderItems: MutableLiveData<List<SliderItem>> = MutableLiveData()

    fun fetchListSlider() {
        val items = listOf(
            SliderItem("48016f549dbc03c0e12190363e687c27", "https://phimimg.com/upload/vod/20241101-1/3757ed8c6566d61cea4ef09246f7918e.jpg"),
            SliderItem("8f698d6fd2865cc064cdfa8b2c5c9c3f", "https://phimimg.com/upload/vod/20241101-1/0f7b77cadbdcd3dac8c46a02a56f4f14.jpg"),
            SliderItem("b7e0f3c8cbc0db30c775aa3c2c74b3a8", "https://phimimg.com/upload/vod/20241102-1/a1ccb430973076351099962a296bbe13.jpg"),
            SliderItem("4849ef4e3811c4b64c2029b7f6f67139", "https://phimimg.com/upload/vod/20241103-1/391cd24f7de65a0243d8952b2fe312cd.jpg"),
            SliderItem("9137d1abcaf9bf4fa41416863f1d3ad1", "https://phimimg.com/upload/vod/20241103-1/0105f2be068851a86c86ab9ce4b4fa08.jpg"),
            SliderItem("4ddb6f74a1c9119602bc9053b5f2b4f3", "https://phimimg.com/upload/vod/20241103-1/8622b6393f89086742ddd484c5ed9d9a.jpg"),
            SliderItem("5731219bff5a342d1ae1d7997b0cad6a", "https://phimimg.com/upload/vod/20241103-1/d12fa4a5b6e1ab39363cc3150709ed77.jpg"),
            SliderItem("460eb45f1f9b67a58c96a73be551f37b", "https://phimimg.com/upload/vod/20241103-1/b3a9c43d56e90456bc836f19bbc30672.jpg"),
            SliderItem("3ac44bdb7fb0bbd5c8b3f4db0218d05e", "https://phimimg.com/upload/vod/20241103-1/3798e9d9efeb85e2be769cc7f6c9f1bb.jpg"),
            SliderItem("a2009556541dfee38d822cf642d80b8c", "https://phimimg.com/upload/vod/20241103-1/712274dbfc32fa658a8360d0f85d6d83.jpg")
        )
        sliderItems.postValue(items)
    }
}