package eu.artistdemoapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by srshe on 05-July-2021
 */
class AlbumDetailsResponse {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("upc")
    @Expose
    var upc: String? = null

    @SerializedName("link")
    @Expose
    var link: String? = null

    @SerializedName("share")
    @Expose
    var share: String? = null

    @SerializedName("cover")
    @Expose
    var cover: String? = null

    @SerializedName("cover_small")
    @Expose
    var coverSmall: String? = null

    @SerializedName("cover_medium")
    @Expose
    var coverMedium: String? = null

    @SerializedName("cover_big")
    @Expose
    var coverBig: String? = null

    @SerializedName("cover_xl")
    @Expose
    var coverXl: String? = null

    @SerializedName("md5_image")
    @Expose
    var md5Image: String? = null

    @SerializedName("genre_id")
    @Expose
    var genreId: Int? = null

    @SerializedName("label")
    @Expose
    var label: String? = null

    @SerializedName("nb_tracks")
    @Expose
    var nbTracks: Int? = null

    @SerializedName("duration")
    @Expose
    var duration: Int? = null

    @SerializedName("fans")
    @Expose
    var fans: Int? = null

    @SerializedName("rating")
    @Expose
    var rating: Int? = null

    @SerializedName("release_date")
    @Expose
    var releaseDate: String? = null

    @SerializedName("record_type")
    @Expose
    var recordType: String? = null

    @SerializedName("available")
    @Expose
    var available: Boolean? = null

    @SerializedName("tracklist")
    @Expose
    var tracklist: String? = null

    @SerializedName("explicit_lyrics")
    @Expose
    var explicitLyrics: Boolean? = null

    @SerializedName("explicit_content_lyrics")
    @Expose
    var explicitContentLyrics: Int? = null

    @SerializedName("explicit_content_cover")
    @Expose
    var explicitContentCover: Int? = null

    @SerializedName("artist")
    @Expose
    var artist: Artist? = null

    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("tracks")
    @Expose
    var tracks: Tracks? = null
}