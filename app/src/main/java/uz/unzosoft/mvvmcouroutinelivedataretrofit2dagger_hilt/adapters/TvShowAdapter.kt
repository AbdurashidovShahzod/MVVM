package uz.unzosoft.mvvmcouroutinelivedataretrofit2dagger_hilt.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import uz.unzosoft.mvvmcouroutinelivedataretrofit2dagger_hilt.databinding.TvShowLayoutBinding
import uz.unzosoft.mvvmcouroutinelivedataretrofit2dagger_hilt.models.TvShowItem

class TvShowAdapter() : RecyclerView.Adapter<TvShowAdapter.MyViewHolder>() {

    lateinit var binding: TvShowLayoutBinding

    inner class MyViewHolder(binding: TvShowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = TvShowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(
            binding
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var currentTvShow = tvShowItem[position]
        binding.tvShow.text = currentTvShow.name
        binding.imageTv.load(currentTvShow.image.original) {
            crossfade(true)
            crossfade(1000)
        }
    }

    override fun getItemCount(): Int = tvShowItem.size


    private val diffCalBack = object : DiffUtil.ItemCallback<TvShowItem>() {

        override fun areItemsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
            return newItem == oldItem
        }

    }
    val differ = AsyncListDiffer(this, diffCalBack)
    var tvShowItem: List<TvShowItem>
        get() = differ.currentList
        set(value) = differ.submitList(value)


}