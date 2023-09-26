package alkusi.kudmi.rabindrapagingroom
import alkusi.kudmi.rabindrapagingroom.MyRepository.MyNetworkRepository
import alkusi.kudmi.rabindrapagingroom.databinding.ActivityMainBinding
import alkusi.kudmi.rabindrapagingroom.paging.FeedPagingAdapter
import alkusi.kudmi.rabindrapagingroom.paging.PagingProgressBarAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding;
    @Inject
    lateinit var myNetworkRepository: MyNetworkRepository
    var adapter:FeedPagingAdapter?=null;
    val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindRv()
        viewModel.getData("632dad2c0c977b2b1d0bae6c")
    }
    private fun bindRv()
    {
         binding.recyclerView.setHasFixedSize(true)
         binding.recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
         adapter = FeedPagingAdapter()
         adapter!!.withLoadStateHeaderAndFooter(header = PagingProgressBarAdapter(), footer = PagingProgressBarAdapter())
         binding.recyclerView.adapter = adapter
         viewModel.liveData.observe(this, Observer { adapter!!.submitData(lifecycle,it) })
    }
}