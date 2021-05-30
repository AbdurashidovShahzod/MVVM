package uz.unzosoft.mvvmcouroutinelivedataretrofit2dagger_hilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.unzosoft.mvvmcouroutinelivedataretrofit2dagger_hilt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}