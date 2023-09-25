package alkusi.kudmi.rabindrapagingroom.Network

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
 class MyInterceptor @Inject constructor() :Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
     val token = "eyJhbGciOiJFUzUxMiIsInR5cCI6IkpXVCJ9.eyJhdWQiOnsiaWQiOiI2Mzk4NDk3ZTk0NTIxYjA1YTE0OTllZmIiLCJwYXNzd29yZCI6IiQyYiQxMiRVZXZzVS5NMXBMQk1YVXg1ZzBWTk1lS3hGMkNFZWlnZzB3eGRCdWlCOXFyLkdtWTZEL1QwLiJ9LCJleHAiOjI2OTUzODMxODAsImlhdCI6MTY5NTM4MzE4MCwiaXNzIjoiR3J1cHBpZSIsImp0aSI6IjlhMTY0MDM0LTQwNzEtNGEyNS1hNDgwLWFiYzViYzU2M2IxMyIsInBlbSI6e30sInN1YiI6eyJpZCI6IjYzOTg0OTdlOTQ1MjFiMDVhMTQ5OWVmYiIsInBhc3N3b3JkIjoiJDJiJDEyJFVldnNVLk0xcExCTVhVeDVnMFZOTWVLeEYyQ0VlaWdnMHd4ZEJ1aUI5cXIuR21ZNkQvVDAuIn0sInR5cCI6ImFjY2VzcyJ9.AWLz-bnoesOph7jF0BeFee4nz5DCYuHJzd7Lfzxexd5LCAxiwLQAXonWtKOdffEL5Mj704ZbF0Ug1EDX80A6FEhBADlSNn0aHx-M7ZlC9Rkj_l7I1ZRn0FmfsUV3WSkQf6UF6aD6OvaYvcUs4xPFWIvb-tF2loECy6RREqM6j-8vcYTH"
        val request = chain.request().newBuilder()
        request.addHeader("Authorization","Bearer $token")

        return chain.proceed(request.build())
    }
}