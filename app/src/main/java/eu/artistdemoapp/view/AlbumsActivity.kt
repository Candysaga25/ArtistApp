package eu.artistdemoapp.view

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import eu.artistdemoapp.R
import eu.artistdemoapp.databinding.ActivityAlbumBinding
import eu.artistdemoapp.model.Album
import eu.artistdemoapp.networkutils.CommonUtils
import eu.artistdemoapp.viewmodel.AlbumViewModel

class AlbumsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlbumBinding
    lateinit var mViewModel: AlbumViewModel
    private val albumListAdapter = AlbumListAdapter { album ->
        val intent = Intent(this, AlbumDetailsActivity::class.java)
        intent.putExtra("albumId", album.id)
        startActivity(intent)

    };

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.title = "Albums"
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true);
        binding.toolbar.setNavigationIcon(R.drawable.ic_action_navigation_arrow_back_inverted)

        mViewModel = ViewModelProvider(this).get(AlbumViewModel::class.java)

        binding.recyclerView.adapter = albumListAdapter

        val bundle: Bundle? = intent.extras
        val artistId: String? = bundle?.getString("artistId")
        val artistName: String? = bundle?.getString("artistName")

        getAlbums(artistName!!, artistId!!)

    }

    private fun getAlbums(artistName: String, artistId: String ){
        if (CommonUtils.isConnectionAvailable(this)) { //Check network status
            mViewModel.getAlbums(artistId)
                .observe(this, { albums: List<Album>? ->
                    if (albums != null) {
                        albumListAdapter.setAlbumList(artistName,albums)
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

}