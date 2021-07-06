package eu.artistdemoapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import eu.artistdemoapp.R
import eu.artistdemoapp.databinding.AdapterAlbumListItemBinding
import eu.artistdemoapp.model.Album

/**Created by srshe on 05-July-2021**/
class AlbumListAdapter(private val listener: (Album) -> Unit) :
    RecyclerView.Adapter<AlbumListAdapter.ViewHolder>() {

    var albums = mutableListOf<Album>()
    var artistName = ""
    fun setAlbumList(artistName: String, albums: List<Album>) {
        this.artistName = artistName
        this.albums = albums.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val binding = AdapterAlbumListItemBinding.inflate(inflater, viewGroup, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val album = albums[position]
        holder.bind(artistName, album)
        holder.itemView.setOnClickListener { listener(album) }
    }

    override fun getItemCount(): Int {
        return albums.size
    }

    class ViewHolder(private val binding: AdapterAlbumListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(artistName: String, album: Album) {
            binding.txtTitle.text = album.title
            binding.txtName.text = artistName
            Glide.with(binding.imgPhoto.context)
                .load(album.coverMedium)
                .error(R.drawable.ic_user)
                .dontAnimate()
                .into(binding.imgPhoto)
        }
    }
}