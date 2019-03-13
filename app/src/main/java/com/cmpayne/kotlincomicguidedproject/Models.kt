package com.cmpayne.kotlincomicguidedproject

import kotlinx.serialization.Serializable

@Serializable
data class CharacterList(
    val error: String? = "",
    val limit: Int? = -1,
    val offset: Int? = -1,
    val number_of_page_results: Int? = -1,
    val number_of_total_results: Int? = -1,
    val status_code: Int? = -1,
    val results: List<Character>? = listOf(Character()),
    val version: String? = ""
)

@Serializable
data class FirstAppearedInIssue(
    val api_detail_url: String? = "",
    val id: Int? = -1,
    val name: String? = "",
    val issue_number: String? = ""
)

@Serializable
data class Image(
    val icon_url: String? = "",
    val medium_url: String? = "",
    val screen_url: String? = "",
    val screen_large_url: String? = "",
    val small_url: String? = "",
    val super_url: String? = "",
    val thumb_url: String? = "",
    val tiny_url: String? = "",
    val original_url: String? = "",
    val image_tags: String? = ""
)

@Serializable
data class Origin(val api_detail_url: String? = "", val id: Int? = -1, val name: String? = "")

@Serializable
data class Publisher(val api_detail_url: String? = "", val id: Int? = -1, val name: String? = "")

@Serializable
data class Character(
    val aliases: String? = "",
    val api_detail_url: String? = "",
    val birth: String? = "",
    val count_of_issue_appearances: Int? = -1,
    val date_added: String? = "",
    val date_last_updated: String? = "",
    val deck: String? = "",
    val description: String? = "",
    val first_appeared_in_issue: FirstAppearedInIssue? = FirstAppearedInIssue(),
    val gender: Int? = -1,
    val id: Int? = -1,
    val image: Image? = Image(),
    val name: String? = "",
    val origin: Origin? = Origin(),
    val publisher: Publisher? = Publisher(),
    val real_name: String? = "",
    val site_detail_url: String? = ""
)

/*
data class CharacterList(
    val error: String,
    val limit: Int,
    val number_of_page_results: Int,
    val number_of_total_results: Int,
    val offset: Int,
    val results: List<Result>,
    val status_code: Int,
    val version: String
)

data class Result(
    val aliases: String,
    val api_detail_url: String,
    val birth: Any,
    val count_of_issue_appearances: Int,
    val date_added: String,
    val date_last_updated: String,
    val deck: String,
    val description: String,
    val first_appearedInIssue: FirstAppearedInIssue,
    val gender: Int,
    val id: Int,
    val image: Image,
    val name: String,
    val origin: Origin,
    val publisher: Publisher,
    val real_name: String,
    val site_detail_url: String
)

data class FirstAppearedInIssue(
    val api_detail_url: String,
    val id: Int,
    val issue_number: String,
    val name: String
)

data class Origin(
    val api_detail_url: String,
    val id: Int,
    val name: String
)

data class Publisher(
    val api_detail_url: String,
    val id: Int,
    val name: String
)

data class Image(
    val icon_url: String,
    val image_tags: String,
    val medium_url: String,
    val original_url: String,
    val screen_large_url: String,
    val screen_url: String,
    val small_url: String,
    val super_url: String,
    val thumb_url: String,
    val tiny_url: String
)*/
