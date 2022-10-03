package coding.withze.chapterlimakmtiga

import retrofit2.Call
import retrofit2.http.*

interface RestfulAPI {
    @GET("admin/car")
    fun getAllCar() : Call<List<ResponseDataCarItem>>

    @POST("admin/car")
    fun addCar(@Body request : DataCar) : Call<PostResponseCar>

    @PUT("admin/car/{id}")
    fun updateCar(@Path("id") id:Int, @Body request: DataCar) : Call<List<PutResponseCar>>
}