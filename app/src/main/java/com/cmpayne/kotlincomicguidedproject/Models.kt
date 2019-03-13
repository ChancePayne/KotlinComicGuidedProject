package com.cmpayne.kotlincomicguidedproject

data class CharacterList(
    val error: String?,
    val limit: Number?,
    val offset: Number?,
    val number_of_page_results: Number?,
    val number_of_total_results: Number?,
    val status_code: Number?,
    val results: List<Character>?,
    val version: String?
)

data class FirstAppearedInIssue(
    val api_detail_url: String?,
    val id: Number?,
    val name: String?,
    val issue_number: String?
)

data class Image(
    val icon_url: String?,
    val medium_url: String?,
    val screen_url: String?,
    val screen_large_url: String?,
    val small_url: String?,
    val super_url: String?,
    val thumb_url: String?,
    val tiny_url: String?,
    val original_url: String?,
    val image_tags: String?
)

data class Origin(val api_detail_url: String?, val id: Number?, val name: String?)

data class Publisher(val api_detail_url: String?, val id: Number?, val name: String?)

data class Character(
    val aliases: String?,
    val api_detail_url: String?,
    val birth: Any?,
    val count_of_issue_appearances: Number?,
    val date_added: String?,
    val date_last_updated: String?,
    val deck: String?,
    val description: String?,
    val first_appearedInIssue: FirstAppearedInIssue?,
    val gender: Number?,
    val id: Number?,
    val image: Image?,
    val name: String?,
    val origin: Origin?,
    val publisher: Publisher?,
    val real_name: String?,
    val site_detail_url: String?
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
