package eu.artistdemoapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import eu.artistdemoapp.model.Artist

/**
 * Created by srshe on 04-July-2021
 */
class MainViewModel() : ViewModel() {
    private val repository: Repository = Repository()
    fun searchArtist(query: String?): LiveData<List<Artist>?> {
        return repository.searchArtist(query)
    }

}