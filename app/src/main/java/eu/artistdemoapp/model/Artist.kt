package eu.artistdemoapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by srshe on 04-July-2021
 */
class Artist {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("link")
    @Expose
    var link: String? = null

    @SerializedName("picture")
    @Expose
    var picture: String? = null

    @SerializedName("picture_small")
    @Expose
    var pictureSmall: String? = null

    @SerializedName("picture_medium")
    @Expose
    var pictureMedium: String? = null

    @SerializedName("picture_big")
    @Expose
    var pictureBig: String? = null

    @SerializedName("picture_xl")
    @Expose
    var pictureXl: String? = null

    @SerializedName("tracklist")
    @Expose
    var tracklist: String? = null

    @SerializedName("type")
    @Expose
    var type: String? = null

}