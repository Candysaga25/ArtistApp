package eu.artistdemoapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import eu.artistdemoapp.model.AlbumDetailsResponse

/**Created by srshe on 05-July-2021**/
class AlbumDetailsViewModel : ViewModel() {
    private val repository: Repository = Repository()
    fun getAlbumsDetails(albumId: String): LiveData<AlbumDetailsResponse> {
        return repository.getAlbumDetails(albumId)
    }
}