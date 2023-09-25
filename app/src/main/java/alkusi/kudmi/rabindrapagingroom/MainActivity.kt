package alkusi.kudmi.rabindrapagingroom

import alkusi.kudmi.rabindrapagingroom.MyRepository.MyNetworkRepository
import alkusi.kudmi.rabindrapagingroom.databinding.ActivityMainBinding
import alkusi.kudmi.rabindrapagingroom.paging.FeedPagingAdapter
import alkusi.kudmi.rabindrapagingroom.paging.PagingProgressBarAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding;
    @Inject
    lateinit var myNetworkRepository: MyNetworkRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myNetworkRepository.getData("6396f93c94521b50103205b7")
        bindRv()
    }
    private fun bindRv()
    {
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
       val adapter = FeedPagingAdapter().withLoadStateHeaderAndFooter(header = PagingProgressBarAdapter(), footer = PagingProgressBarAdapter())
        binding.recyclerView.adapter = adapter
    }
}