package uz.unzosoft.mvvmcouroutinelivedataretrofit2dagger_hilt.api

import retrofit2.Response
import retrofit2.http.GET
import uz.unzosoft.mvvmcouroutinelivedataretrofit2dagger_hilt.helper.constants.Constants
import uz.unzosoft.mvvmcouroutinelivedataretrofit2dagger_hilt.models.TvShowResponse

interface ApiService {


    @GET(Constants.BASE_URL)
    suspend fun getTvShows(): Response<TvShowResponse>

}