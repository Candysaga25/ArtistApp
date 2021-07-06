package eu.artistdemoapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import eu.artistdemoapp.R
import eu.artistdemoapp.databinding.ActivityAlbumDetailsBinding
import eu.artistdemoapp.model.AlbumDetailsResponse
import eu.artistdemoapp.networkutils.CommonUtils
import eu.artistdemoapp.viewmodel.AlbumDetailsViewModel

class AlbumDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlbumDetailsBinding
    lateinit var mViewModel: AlbumDetailsViewModel
    private val trackListAdapter = TrackListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.title = ""
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true);
        binding.toolbar.setNavigationIcon(R.drawable.ic_action_navigation_arrow_back_inverted)

        mViewModel = ViewModelProvider(this).get(AlbumDetailsViewModel::class.java)

        val bundle: Bundle? = intent.extras
        val albumId: String? = bundle?.getString("albumId")

        getAlbumsDetails(albumId!!)

        binding.recyclerViewTracks.adapter = trackListAdapter

    }
    private fun getAlbumsDetails(albumId: String){
        if (CommonUtils.isConnectionAvailable(this)) { //Check network status
            mViewModel.getAlbumsDetails(albumId)
                .observe(this, { albumDetailsResponse: AlbumDetailsResponse? ->
                    if (albumDetailsResponse != null) {
                             updateUI(albumDetailsResponse)
                    }
                })
        } else {
            Toast.makeText(
                this,
                getString(R.string.network_error),
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                //handle the home button onClick event here.
                onBackPressed()
                return true
            }
        }
        return true
    }

   private fun updateUI(albumDetailsResponse : AlbumDetailsResponse){
        Glide.with(this)
            .load(albumDetailsResponse.coverBig)
            .error(R.drawable.music)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.imgCoverPhoto)
        binding.txtAlbumTitle.text = albumDetailsResponse.title
        binding.txtArtistName.text = albumDetailsResponse.artist?.name
        trackListAdapter.setTrackList(albumDetailsResponse.artist?.name,
            albumDetailsResponse.tracks?.data)
    }


}