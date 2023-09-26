package alkusi.kudmi.rabindrapagingroom
import alkusi.kudmi.rabindrapagingroom.MyRepository.MyNetworkRepository
import alkusi.kudmi.rabindrapagingroom.model.MyFeedData
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingData
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MainViewModel @Inject constructor(val myNetworkRepository: MyNetworkRepository):ViewModel() {
    val mutableData = MutableLiveData<PagingData<MyFeedData>>()
    val liveData
        get() = mutableData
    fun getData(groupId:String)
    {
        viewModelScope.launch {
            val data = myNetworkRepository.getData(groupId)
            data.catch {  }
                .collect{
                    Log.e("rabindra","data->"+ Gson().toJson(it))
                    mutableData.postValue(it)
                }
        }
    }
}


