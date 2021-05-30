package uz.unzosoft.mvvmcouroutinelivedataretrofit2dagger_hilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uz.unzosoft.mvvmcouroutinelivedataretrofit2dagger_hilt.adapters.TvShowAdapter
import uz.unzosoft.mvvmcouroutinelivedataretrofit2dagger_hilt.databinding.ActivityMainBinding
import uz.unzosoft.mvvmcouroutinelivedataretrofit2dagger_hilt.viewmodels.TvShowViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: TvShowViewModel by viewModels()
    lateinit var adapter: TvShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRv()


    }

    private fun setupRv() {
        adapter = TvShowAdapter()
        binding.rv.adapter = adapter
        binding.rv2.adapter = adapter
        binding.rv.setHasFixedSize(true)
        viewModel.responseTvShow.observe(this, { listTvShows ->
            adapter.tvShowItem = listTvShows
        })
    }

}