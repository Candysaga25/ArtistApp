package eu.artistdemoapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by srshe on 05-July-2021
 */
class Track {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("readable")
    @Expose
    var readable: Boolean? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("title_short")
    @Expose
    var titleShort: String? = null

    @SerializedName("title_version")
    @Expose
    var titleVersion: String? = null

    @SerializedName("link")
    @Expose
    var link: String? = null

    @SerializedName("duration")
    @Expose
    var duration: String? = null

    @SerializedName("rank")
    @Expose
    var rank: String? = null

    @SerializedName("explicit_lyrics")
    @Expose
    var explicitLyrics: Boolean? = null

    @SerializedName("explicit_content_lyrics")
    @Expose
    var explicitContentLyrics: Int? = null

    @SerializedName("explicit_content_cover")
    @Expose
    var explicitContentCover: Int? = null

    @SerializedName("preview")
    @Expose
    var preview: String? = null

    @SerializedName("md5_image")
    @Expose
    var md5Image: String? = null

    @SerializedName("artist")
    @Expose
    var artist: Artist? = null

    @SerializedName("type")
    @Expose
    var type: String? = null
}