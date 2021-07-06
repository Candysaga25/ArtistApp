package eu.artistdemoapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by srshe on 04-July-2021
 */
class SearchResponse {
    @SerializedName("data")
    @Expose
    var data: List<Artist>? = null

    @SerializedName("total")
    @Expose
    var total = 0

    @SerializedName("next")
    @Expose
    var next: String? = null
}