package uz.unzosoft.mvvmcouroutinelivedataretrofit2dagger_hilt.repository

import uz.unzosoft.mvvmcouroutinelivedataretrofit2dagger_hilt.api.ApiService
import javax.inject.Inject

class TvShowRepository
@Inject constructor(
    private val api: ApiService
) {
    suspend fun getTvShows() = api.getTvShows()
}