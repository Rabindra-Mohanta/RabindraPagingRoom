package alkusi.kudmi.rabindrapagingroom.Network

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
 class MyInterceptor @Inject constructor() :Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
     val token = "eyJhbGciOiJFUzUxMiIsInR5cCI6IkpXVCJ9.eyJhdWQiOnsiaWQiOiI2MzJlOTY2OTBjOTc3YjJiMWQ5MTNhYzYiLCJwYXNzd29yZCI6IiQyYiQxMiQ2QU04T2dBRzVQR3MyZHhPc0VDRUpPOExmRHpheS5KSXFtd2tMRHNpSnJhaGJnYzRqQmZWcSJ9LCJleHAiOjI2OTUyMDg0NTAsImlhdCI6MTY5NTIwODQ1MCwiaXNzIjoiR3J1cHBpZSIsImp0aSI6IjBmMTZiOTkwLThhZjktNDg2Mi1iYWY2LTc0OTRjNTc1OWJiYSIsInBlbSI6e30sInN1YiI6eyJpZCI6IjYzMmU5NjY5MGM5NzdiMmIxZDkxM2FjNiIsInBhc3N3b3JkIjoiJDJiJDEyJDZBTThPZ0FHNVBHczJkeE9zRUNFSk84TGZEemF5LkpJcW13a0xEc2lKcmFoYmdjNGpCZlZxIn0sInR5cCI6ImFjY2VzcyJ9.AfnFAV6k66YL9L_SMAsXQ_e4rPZxBGFGKf-O5lfKfTVI6tn6Po7DOkdytvuJS27kUwUjFVr4pBBEhPkFj7ns_usfAbALsAyKQIF_7nD7fpHT8yMz_yXB1zmrsx-lvABDXyPOH0UoXOtjYh1Iq9lasSo2IXPJ3ZtkLGREHNCSrVXDqHGL"
        val request = chain.request().newBuilder()
        request.addHeader("Authorization","Bearer $token")

        return chain.proceed(request.build())
    }
}