package alkusi.kudmi.rabindrapagingroom.paging
import alkusi.kudmi.rabindrapagingroom.Network.MyApi
import alkusi.kudmi.rabindrapagingroom.model.MyFeedData
import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState

const val STATING_PAGE = 1;
class PagingSource(val groupId:String,val myApi: MyApi):PagingSource<Int,MyFeedData>()
{
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MyFeedData> {
       return try {
            val currentPage = params.key?: STATING_PAGE
            val res = myApi.getPost(groupId,currentPage)
           Log.e("rabindra","url->"+res.raw().request.url)
           LoadResult.Page(
               data = res.body()!!.data,
               prevKey = if(currentPage==1)null else currentPage-1,
               nextKey = if(currentPage==res.body()!!.totalNumberOfPages)null else  currentPage+1
           )
        }
        catch (e:Exception)
        {
            LoadResult.Error(e)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, MyFeedData>): Int? {
       return state.anchorPosition?.let {
           val anchorPage =  state.closestPageToPosition(it)
           anchorPage?.prevKey?.plus(1)?: anchorPage?.nextKey?.minus(1)
       }
    }
}
