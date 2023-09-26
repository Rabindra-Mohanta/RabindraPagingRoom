package alkusi.kudmi.rabindrapagingroom.paging
import alkusi.kudmi.rabindrapagingroom.databinding.FeedItemBinding
import alkusi.kudmi.rabindrapagingroom.model.MyFeedData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
class FeedPagingAdapter():PagingDataAdapter<MyFeedData,FeedPagingAdapter.ViewHolder>(COMPARATOR()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val binding = FeedItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            
            holder.bindData(it)
        }

    }
    inner class ViewHolder(val binding: FeedItemBinding):RecyclerView.ViewHolder(binding.root)
    {
fun bindData(data: MyFeedData)
{
    binding.txtView.setText(data.updatedAt)
}
    }

    companion object
    {
        fun COMPARATOR () = object :DiffUtil.ItemCallback<MyFeedData>()
        {
            override fun areItemsTheSame(oldItem: MyFeedData, newItem: MyFeedData): Boolean {
                 return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MyFeedData, newItem: MyFeedData): Boolean {
                 return oldItem.equals(newItem)
            }

        }
    }

}