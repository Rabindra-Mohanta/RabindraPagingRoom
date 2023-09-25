package alkusi.kudmi.rabindrapagingroom.paging

import alkusi.kudmi.rabindrapagingroom.databinding.ItemProgressBarBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView

class PagingProgressBarAdapter():LoadStateAdapter<PagingProgressBarAdapter.ViewHolder>(){
    inner class ViewHolder(val binding:ItemProgressBarBinding):RecyclerView.ViewHolder(binding.root)
    {
        fun bind(loadState: LoadState)
        {
              binding.progressBar.isVisible = loadState is LoadState.Loading
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, loadState: LoadState) {
       holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): ViewHolder {
       val bin = ItemProgressBarBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(bin)
    }
}