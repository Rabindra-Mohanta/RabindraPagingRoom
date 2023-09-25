package alkusi.kudmi.rabindrapagingroom.MyRepository

import alkusi.kudmi.rabindrapagingroom.Network.MyApi
import alkusi.kudmi.rabindrapagingroom.paging.PagingSource
import androidx.paging.Pager
import androidx.paging.PagingConfig
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyNetworkRepository @Inject constructor(private val myApi: MyApi){
    fun getData(groupId:String) = Pager(
        config = PagingConfig(15,40),
        pagingSourceFactory = {PagingSource(groupId,myApi)}
    ).flow
}