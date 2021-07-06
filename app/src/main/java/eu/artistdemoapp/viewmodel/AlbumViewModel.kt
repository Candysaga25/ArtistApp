package eu.artistdemoapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import eu.artistdemoapp.model.Album

/**Created by srshe on 04-July-2021**/
class AlbumViewModel : ViewModel() {
    private val repository: Repository = Repository()
    fun getAlbums(artistId: String?): LiveData<List<Album>?> {
        return repository.getAlbums(artistId)
    }
}