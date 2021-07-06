package eu.artistdemoapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import eu.artistdemoapp.model.*
import eu.artistdemoapp.networkutils.ArtistApiService
import eu.artistdemoapp.networkutils.Logger
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by srshe on 04-July-2021
 */
class Repository() {
    private val artistList: MutableLiveData<List<Artist>?> = MutableLiveData()
    private val albumList: MutableLiveData<List<Album>?> = MutableLiveData()
    private var albumDetailsResponse: MutableLiveData<AlbumDetailsResponse> = MutableLiveData()

    fun searchArtist(query: String?): LiveData<List<Artist>?> {
        val artistApiService = ArtistApiService.getInstance();
        artistApiService.searchArtist(query)?.enqueue(object : Callback<SearchResponse?> {
            override fun onResponse(
                call: Call<SearchResponse?>,
                response: Response<SearchResponse?>
            ) {
                if (response.isSuccessful) {
                    artistList.setValue(response.body()!!.data)
                } else {
                    Logger.debug("Error", response.message())
                }
            }

            override fun onFailure(call: Call<SearchResponse?>, t: Throwable) {
                Logger.debug("Error", t.message)
            }
        })
        return artistList
    }

    fun getAlbums(artistId: String?): LiveData<List<Album>?> {
        val artistApiService = ArtistApiService.getInstance();
        artistApiService.getAlbumByArtistId(artistId)?.enqueue(object : Callback<AlbumsResponse?> {
            override fun onResponse(
                call: Call<AlbumsResponse?>,
                response: Response<AlbumsResponse?>
            ) {
                if (response.isSuccessful) {
                    albumList.setValue(response.body()!!.data)
                } else {
                    Logger.debug("Error", response.message())
                }
            }

            override fun onFailure(call: Call<AlbumsResponse?>, t: Throwable) {
                Logger.debug("Error", t.message)
            }
        })
        return albumList
    }

    fun getAlbumDetails(albumId: String): LiveData<AlbumDetailsResponse> {
        val artistApiService = ArtistApiService.getInstance();
        artistApiService.getAlbumDetailsByAlbumId(albumId)
            ?.enqueue(object : Callback<AlbumDetailsResponse?> {
                override fun onResponse(
                    call: Call<AlbumDetailsResponse?>,
                    response: Response<AlbumDetailsResponse?>
                ) {
                    if (response.isSuccessful) {
                        albumDetailsResponse.value = response.body()
                    } else {
                        Logger.debug("Error", response.message())
                    }
                }

                override fun onFailure(call: Call<AlbumDetailsResponse?>, t: Throwable) {
                    Logger.debug("Error", t.message)
                }
            })
        return albumDetailsResponse
    }
}