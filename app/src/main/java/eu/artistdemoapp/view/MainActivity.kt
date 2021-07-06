package eu.artistdemoapp.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.miguelcatalan.materialsearchview.MaterialSearchView
import eu.artistdemoapp.R
import eu.artistdemoapp.databinding.ActivityMainBinding
import eu.artistdemoapp.model.Artist
import eu.artistdemoapp.networkutils.CommonUtils.isConnectionAvailable
import eu.artistdemoapp.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var mViewModel: MainViewModel

    private val artistListAdapter = ArtistListAdapter() { artist ->
        val intent = Intent(this, AlbumsActivity::class.java)
        intent.putExtra("artistId", artist.id)
        intent.putExtra("artistName", artist.name)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.title = ""
        setSupportActionBar(binding.toolbar)

        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.recyclerView.adapter = artistListAdapter

        binding.searchView.setOnQueryTextListener(object : MaterialSearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                searchArtist(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                searchArtist(newText)
                return false
            }
        })
    }

    fun searchArtist(query: String) {
        if (isConnectionAvailable(this)) { //Check network status
            mViewModel.searchArtist("artist:\"$query\"")
                .observe(this, { artists: List<Artist>? ->
                    if (artists != null) {
                        updateUI()
                        artistListAdapter.setArtistList(artists)
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val item: MenuItem = menu.findItem(R.id.action_search)
        binding.searchView.setMenuItem(item)
        return true
    }

    private fun updateUI() {
        binding.recyclerView.visibility = View.VISIBLE
        binding.imgHint.visibility = View.GONE
        binding.txtHint.visibility = View.GONE
    }
}