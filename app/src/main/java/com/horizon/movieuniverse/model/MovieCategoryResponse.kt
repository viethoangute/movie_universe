package com.horizon.movieuniverse.model

import com.google.gson.annotations.SerializedName

data class MovieCategoryResponse(
    @SerializedName("status") val status: String,
    @SerializedName("msg") val msg: String,
    @SerializedName("data") val data: CategoryData
)

data class CategoryData(
    @SerializedName("seoOnPage") val seoOnPage: SeoOnPage,
    @SerializedName("breadCrumb") val breadCrumb: List<BreadCrumb>,
    @SerializedName("titlePage") val titlePage: String,
    @SerializedName("items") val items: List<MovieItemFromCategory>,
    @SerializedName("params") val params: Params,
    @SerializedName("type_list") val typeList: String,
    @SerializedName("APP_DOMAIN_FRONTEND") val appDomainFrontEnd: String,
    @SerializedName("APP_DOMAIN_CDN_IMAGE") val appDomainCdnImage: String
)

data class SeoOnPage(
    @SerializedName("og_type") val ogType: String,
    @SerializedName("titleHead") val titleHead: String,
    @SerializedName("descriptionHead") val descriptionHead: String,
    @SerializedName("og_image") val ogImage: List<String>,
    @SerializedName("og_url") val ogUrl: String
)

data class BreadCrumb(
    @SerializedName("name") val name: String,
    @SerializedName("slug") val slug: String,
    @SerializedName("isCurrent") val isCurrent: Boolean,
    @SerializedName("position") val position: Int
)

data class MovieItemFromCategory(
    @SerializedName("modified") val modified: ModifiedCategory,
    @SerializedName("_id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("slug") val slug: String,
    @SerializedName("origin_name") val originName: String,
    @SerializedName("type") val type: String,
    @SerializedName("poster_url") val posterUrl: String,
    @SerializedName("thumb_url") val thumbUrl: String,
    @SerializedName("sub_docquyen") val subDocQuyen: Boolean,
    @SerializedName("chieurap") val chieuRap: Boolean,
    @SerializedName("time") val time: String,
    @SerializedName("episode_current") val episodeCurrent: String,
    @SerializedName("quality") val quality: String,
    @SerializedName("lang") val lang: String,
    @SerializedName("year") val year: Int,
    @SerializedName("category") val category: List<CategoryFromCategory>,
    @SerializedName("country") val country: List<Country>
)

data class ModifiedCategory(
    @SerializedName("time") val time: String
)

data class CategoryFromCategory(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("slug") val slug: String
)

data class Country(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("slug") val slug: String
)

data class Params(
    @SerializedName("type_slug") val typeSlug: String,
    @SerializedName("filterCategory") val filterCategory: List<String>,
    @SerializedName("filterCountry") val filterCountry: List<String>,
    @SerializedName("filterYear") val filterYear: String,
    @SerializedName("filterType") val filterType: String,
    @SerializedName("sortField") val sortField: String,
    @SerializedName("sortType") val sortType: String,
    @SerializedName("pagination") val pagination: PaginationFromCategory
)

data class PaginationFromCategory(
    @SerializedName("totalItems") val totalItems: Int,
    @SerializedName("totalItemsPerPage") val totalItemsPerPage: Int,
    @SerializedName("currentPage") val currentPage: Int,
    @SerializedName("totalPages") val totalPages: Int
)