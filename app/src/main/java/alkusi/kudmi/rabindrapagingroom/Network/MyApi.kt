package alkusi.kudmi.rabindrapagingroom.Network
import alkusi.kudmi.rabindrapagingroom.model.FeedData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
interface MyApi {
    @GET("api/v1/groups/{groups_id}/all/post/get")
    suspend fun getPost(@Path("groups_id") groupsId:String,@Query("page") page:Int):Response<FeedData>
}
