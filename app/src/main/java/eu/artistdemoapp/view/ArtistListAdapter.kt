package eu.artistdemoapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import eu.artistdemoapp.R
import eu.artistdemoapp.databinding.AdapterArtistListItemBinding
import eu.artistdemoapp.model.Artist

/**
 * Created by srshe on 04-July-2021
 */
class ArtistListAdapter (private val listener: (Artist) -> Unit): RecyclerView.Adapter<ArtistListAdapter.ViewHolder>() {

    var artists = mutableListOf<Artist>()

    fun setArtistList(artistList: List<Artist>) {
        this.artists = artistList.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val binding = AdapterArtistListItemBinding.inflate(inflater, viewGroup, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val artist = artists[position]
        holder.binding.txtName.text = artist.name
        Glide.with(holder.binding.imgPhoto.context)
                .load(artist.pictureMedium)
                .error(R.drawable.ic_user)
                .dontAnimate()
                .into(holder.binding.imgPhoto)

        holder.itemView.setOnClickListener { listener(artist) }

    }

    override fun getItemCount(): Int {
        return artists.size
    }

    class ViewHolder(val binding: AdapterArtistListItemBinding) : RecyclerView.ViewHolder(binding.root)
}