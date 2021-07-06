package eu.artistdemoapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import eu.artistdemoapp.databinding.AdapterTrackListItemBinding
import eu.artistdemoapp.model.Track

/**Created by srshe on 05-July-2021**/
class TrackListAdapter() : RecyclerView.Adapter<TrackListAdapter.ViewHolder>() {

    var tracks = mutableListOf<Track>()
    private var artistName: String? = null

    fun setTrackList(artistName: String?, trackList: List<Track>?) {
        this.artistName = artistName
        this.tracks = trackList?.toMutableList() ?: mutableListOf<Track>()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val binding = AdapterTrackListItemBinding.inflate(inflater, viewGroup, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val track = tracks[position]
        holder.binding.txtTitle.text = track.title
        holder.binding.txtName.text = artistName
        holder.binding.txtIndex.text = position.plus(1).toString()

    }

    override fun getItemCount(): Int {
        return tracks.size
    }

    class ViewHolder(val binding: AdapterTrackListItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}