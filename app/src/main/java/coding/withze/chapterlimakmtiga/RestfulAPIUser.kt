package coding.withze.chapterlimakmtiga

import retrofit2.Call
import retrofit2.http.GET

interface RestfulAPIUser {
    @GET("user")
    fun getAllUser() : Call<List<ResponseDataUserItem>>
}