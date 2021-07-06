package eu.artistdemoapp.networkutils

import eu.artistdemoapp.model.AlbumDetailsResponse
import eu.artistdemoapp.model.AlbumsResponse
import eu.artistdemoapp.model.SearchResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

/**
 * Created by srshe on 04-July-2021
 */
interface ArtistApiService {

    //https://developers.deezer.com/search/artist?q=artist:"query"
    @GET("search/artist")
    fun searchArtist(@Query("q") artist: String?): Call<SearchResponse?>?

    //https://api.deezer.com/artist/27/albums
    @GET("artist/{artistId}/albums")
    fun getAlbumByArtistId(@Path("artistId") artistID: String?): Call<AlbumsResponse?>?

    //https://api.deezer.com/album/302127
    @GET("album/{albumId}")
    fun getAlbumDetailsByAlbumId(@Path("albumId") albumId: String?): Call<AlbumDetailsResponse?>?

    companion object {
         fun getInstance()  : ArtistApiService {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val okkHttpclient = OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build()

            return Retrofit.Builder()
                .client(okkHttpclient)
                .baseUrl("https://api.deezer.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ArtistApiService::class.java)
        }
    }
}