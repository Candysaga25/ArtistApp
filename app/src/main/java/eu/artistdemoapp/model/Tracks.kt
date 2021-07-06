package eu.artistdemoapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by srshe on 05-July-2021
 */
class Tracks {
    @SerializedName("data")
    @Expose
    var data: List<Track>? = null
}