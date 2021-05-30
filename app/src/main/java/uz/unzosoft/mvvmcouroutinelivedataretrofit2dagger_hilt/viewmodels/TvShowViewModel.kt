package uz.unzosoft.mvvmcouroutinelivedataretrofit2dagger_hilt.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.unzosoft.mvvmcouroutinelivedataretrofit2dagger_hilt.models.TvShowItem
import uz.unzosoft.mvvmcouroutinelivedataretrofit2dagger_hilt.repository.TvShowRepository
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel
@Inject constructor(
    private val repository: TvShowRepository
) : ViewModel() {

    private val _response = MutableLiveData<List<TvShowItem>>()
    val responseTvShow: LiveData<List<TvShowItem>> get() = _response

    init {
        getAllTvShows()
    }

    private fun getAllTvShows() = viewModelScope.launch {
        repository.getTvShows().let { response ->
            if (response.isSuccessful) {
                _response.postValue(response.body())
                Log.d("RESPONSE SUCCESSFUL:", "getAllTvShows:${response.body()}")
            } else {
                Log.d(
                    "RESPONSE ERROR:",
                    "getAllTvShows: ${response.code()}\n${response.errorBody()}"
                )
            }
        }
    }
}