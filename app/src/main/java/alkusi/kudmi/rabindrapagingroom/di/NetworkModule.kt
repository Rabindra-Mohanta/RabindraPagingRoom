package alkusi.kudmi.rabindrapagingroom.di
import alkusi.kudmi.rabindrapagingroom.Network.MyApi
import alkusi.kudmi.rabindrapagingroom.Network.MyInterceptor
import alkusi.kudmi.rabindrapagingroom.Utils.Constants.BASE_URL
import alkusi.kudmi.rabindrapagingroom.db.MyRoomDb
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun getOkHttp(myInterceptor:MyInterceptor):OkHttpClient
    {
        return OkHttpClient.Builder().addInterceptor(myInterceptor).build()
    }
    @Singleton
    @Provides
    fun getRetrofit(okHttpClient: OkHttpClient):Retrofit
    {
        return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build()
    }
    @Singleton
    @Provides
    fun getMyApi(retrofit: Retrofit):MyApi
    {
        return retrofit.create(MyApi::class.java)
    }

}