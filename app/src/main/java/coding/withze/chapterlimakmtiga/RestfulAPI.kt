package coding.withze.chapterlimakmtiga

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RestfulAPI {
    @GET("admin/car")
    fun getAllCar() : Call<List<ResponseDataCarItem>>

    @POST("admin/car")
    fun addCar(@Body request : DataCar) : Call<PostResponseCar>
}