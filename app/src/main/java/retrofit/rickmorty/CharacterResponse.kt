package retrofit.rickmorty


import android.annotation.SuppressLint
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@SuppressLint("ParcelCreator")
@Parcelize
data class CharacterResponse(
    @SerializedName("info")
    val info: Info = Info(),
    @SerializedName("results")
    val results: MutableSet<Result> = mutableSetOf()
) : Parcelable {
    @SuppressLint("ParcelCreator")
    @Parcelize
    data class Info(
        @SerializedName("count")
        val count: Int = 0,
        @SerializedName("next")
        val next: String? = "",
        @SerializedName("pages")
        val pages: Int = 0,
        @SerializedName("prev")
        val prev: @RawValue Any = Any()
    ) : Parcelable

    @SuppressLint("ParcelCreator")
    @Parcelize
    data class Result(
        @SerializedName("created")
        val created: String = "",
        @SerializedName("episode")
        val episode: List<String> = listOf(),
        @SerializedName("gender")
        val gender: String = "",
        @SerializedName("id")
        val id: Int = 0,
        @SerializedName("image")
        val image: String = "",
        @SerializedName("location")
        val location: Location = Location(),
        @SerializedName("name")
        val name: String = "",
        @SerializedName("origin")
        val origin: Origin = Origin(),
        @SerializedName("species")
        val species: String = "",
        @SerializedName("status")
        val status: String = "",
        @SerializedName("type")
        val type: String = "",
        @SerializedName("url")
        val url: String = ""
    ) : Parcelable {
        @SuppressLint("ParcelCreator")
        @Parcelize
        data class Location(
            @SerializedName("name")
            val name: String = "",
            @SerializedName("url")
            val url: String = ""
        ) : Parcelable

        @SuppressLint("ParcelCreator")
        @Parcelize
        data class Origin(
            @SerializedName("name")
            val name: String = "",
            @SerializedName("url")
            val url: String = ""
        ) : Parcelable
    }
}