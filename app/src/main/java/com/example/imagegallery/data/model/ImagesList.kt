package com.example.imagegallery.data.model


import com.google.gson.annotations.SerializedName

class ImagesList : ArrayList<ImagesList.ImagesListItem>(){
    data class ImagesListItem(
        @SerializedName("alt_description")
        var altDescription: String? = null,
        @SerializedName("blur_hash")
        var blurHash: String? = null,
        @SerializedName("categories")
        var categories: List<Any?>? = null,
        @SerializedName("color")
        var color: String? = null,
        @SerializedName("created_at")
        var createdAt: String? = null,
        @SerializedName("current_user_collections")
        var currentUserCollections: List<Any?>? = null,
        @SerializedName("description")
        var description: String? = null,
        @SerializedName("height")
        var height: Int? = null,
        @SerializedName("id")
        var id: String? = null,
        @SerializedName("liked_by_user")
        var likedByUser: Boolean? = null,
        @SerializedName("likes")
        var likes: Int? = null,
        @SerializedName("links")
        var links: Links? = null,
        @SerializedName("promoted_at")
        var promotedAt: String? = null,
        @SerializedName("sponsorship")
        var sponsorship: Sponsorship? = null,
        @SerializedName("topic_submissions")
        var topicSubmissions: TopicSubmissions? = null,
        @SerializedName("updated_at")
        var updatedAt: String? = null,
        @SerializedName("urls")
        var urls: Urls? = null,
        @SerializedName("user")
        var user: User? = null,
        @SerializedName("width")
        var width: Int? = null
    ) {
        data class Links(
            @SerializedName("download")
            var download: String? = null,
            @SerializedName("download_location")
            var downloadLocation: String? = null,
            @SerializedName("html")
            var html: String? = null,
            @SerializedName("self")
            var self: String? = null
        )

        data class Sponsorship(
            @SerializedName("impression_urls")
            var impressionUrls: List<String?>? = null,
            @SerializedName("sponsor")
            var sponsor: Sponsor? = null,
            @SerializedName("tagline")
            var tagline: String? = null,
            @SerializedName("tagline_url")
            var taglineUrl: String? = null
        ) {
            data class Sponsor(
                @SerializedName("accepted_tos")
                var acceptedTos: Boolean? = null,
                @SerializedName("bio")
                var bio: String? = null,
                @SerializedName("first_name")
                var firstName: String? = null,
                @SerializedName("for_hire")
                var forHire: Boolean? = null,
                @SerializedName("id")
                var id: String? = null,
                @SerializedName("instagram_username")
                var instagramUsername: String? = null,
                @SerializedName("last_name")
                var lastName: Any? = null,
                @SerializedName("links")
                var links: Links? = null,
                @SerializedName("location")
                var location: Any? = null,
                @SerializedName("name")
                var name: String? = null,
                @SerializedName("portfolio_url")
                var portfolioUrl: String? = null,
                @SerializedName("profile_image")
                var profileImage: ProfileImage? = null,
                @SerializedName("social")
                var social: Social? = null,
                @SerializedName("total_collections")
                var totalCollections: Int? = null,
                @SerializedName("total_likes")
                var totalLikes: Int? = null,
                @SerializedName("total_photos")
                var totalPhotos: Int? = null,
                @SerializedName("twitter_username")
                var twitterUsername: String? = null,
                @SerializedName("updated_at")
                var updatedAt: String? = null,
                @SerializedName("username")
                var username: String? = null
            ) {
                data class Links(
                    @SerializedName("followers")
                    var followers: String? = null,
                    @SerializedName("following")
                    var following: String? = null,
                    @SerializedName("html")
                    var html: String? = null,
                    @SerializedName("likes")
                    var likes: String? = null,
                    @SerializedName("photos")
                    var photos: String? = null,
                    @SerializedName("portfolio")
                    var portfolio: String? = null,
                    @SerializedName("self")
                    var self: String? = null
                )

                data class ProfileImage(
                    @SerializedName("large")
                    var large: String? = null,
                    @SerializedName("medium")
                    var medium: String? = null,
                    @SerializedName("small")
                    var small: String? = null
                )

                data class Social(
                    @SerializedName("instagram_username")
                    var instagramUsername: String? = null,
                    @SerializedName("paypal_email")
                    var paypalEmail: Any? = null,
                    @SerializedName("portfolio_url")
                    var portfolioUrl: String? = null,
                    @SerializedName("twitter_username")
                    var twitterUsername: String? = null
                )
            }
        }

        class TopicSubmissions

        data class Urls(
            @SerializedName("full")
            var full: String? = null,
            @SerializedName("raw")
            var raw: String? = null,
            @SerializedName("regular")
            var regular: String? = null,
            @SerializedName("small")
            var small: String? = null,
            @SerializedName("small_s3")
            var smallS3: String? = null,
            @SerializedName("thumb")
            var thumb: String? = null
        )

        data class User(
            @SerializedName("accepted_tos")
            var acceptedTos: Boolean? = null,
            @SerializedName("bio")
            var bio: String? = null,
            @SerializedName("first_name")
            var firstName: String? = null,
            @SerializedName("for_hire")
            var forHire: Boolean? = null,
            @SerializedName("id")
            var id: String? = null,
            @SerializedName("instagram_username")
            var instagramUsername: String? = null,
            @SerializedName("last_name")
            var lastName: String? = null,
            @SerializedName("links")
            var links: Links? = null,
            @SerializedName("location")
            var location: Any? = null,
            @SerializedName("name")
            var name: String? = null,
            @SerializedName("portfolio_url")
            var portfolioUrl: String? = null,
            @SerializedName("profile_image")
            var profileImage: ProfileImage? = null,
            @SerializedName("social")
            var social: Social? = null,
            @SerializedName("total_collections")
            var totalCollections: Int? = null,
            @SerializedName("total_likes")
            var totalLikes: Int? = null,
            @SerializedName("total_photos")
            var totalPhotos: Int? = null,
            @SerializedName("twitter_username")
            var twitterUsername: String? = null,
            @SerializedName("updated_at")
            var updatedAt: String? = null,
            @SerializedName("username")
            var username: String? = null
        ) {
            data class Links(
                @SerializedName("followers")
                var followers: String? = null,
                @SerializedName("following")
                var following: String? = null,
                @SerializedName("html")
                var html: String? = null,
                @SerializedName("likes")
                var likes: String? = null,
                @SerializedName("photos")
                var photos: String? = null,
                @SerializedName("portfolio")
                var portfolio: String? = null,
                @SerializedName("self")
                var self: String? = null
            )

            data class ProfileImage(
                @SerializedName("large")
                var large: String? = null,
                @SerializedName("medium")
                var medium: String? = null,
                @SerializedName("small")
                var small: String? = null
            )

            data class Social(
                @SerializedName("instagram_username")
                var instagramUsername: String? = null,
                @SerializedName("paypal_email")
                var paypalEmail: Any? = null,
                @SerializedName("portfolio_url")
                var portfolioUrl: String? = null,
                @SerializedName("twitter_username")
                var twitterUsername: String? = null
            )
        }
    }
}