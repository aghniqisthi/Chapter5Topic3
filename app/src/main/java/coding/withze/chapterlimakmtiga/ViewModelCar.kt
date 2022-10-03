package coding.withze.chapterlimakmtiga

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelCar : ViewModel() {

    lateinit var liveDataCar : MutableLiveData<List<ResponseDataCarItem>>
    lateinit var postLDCar : MutableLiveData<PostResponseCar>
    lateinit var putLDCar : MutableLiveData<PutResponseCar>

    init {
        liveDataCar = MutableLiveData()
        postLDCar = MutableLiveData()
        putLDCar = MutableLiveData()
    }

    fun ambilLiveDataCar() : MutableLiveData<List<ResponseDataCarItem>>{
        return liveDataCar
    }

    fun addLiveDataCar() : MutableLiveData<PostResponseCar>{
        return postLDCar
    }

    fun editLiveDataCar() : MutableLiveData<PutResponseCar>{
        return putLDCar
    }

    fun callPutAPICar(id:Int, name:String, category:String, price:Int, status:Boolean, image:String){
        RetrofitClient.instance.updateCar(id, DataCar(name, category, price, status, image)).enqueue(object : Callback<List<PutResponseCar>>{
            override fun onResponse(call: Call<List<PutResponseCar>>, response: Response<List<PutResponseCar>>) {
                if(response.isSuccessful){
                    putLDCar.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<List<PutResponseCar>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun callPostAPICar(name:String, category:String, price:Int, status:Boolean, image:String){
        RetrofitClient.instance.addCar(DataCar(name, category, price, status, image)).enqueue(object :Callback<PostResponseCar>{
            override fun onResponse(call: Call<PostResponseCar>, response: Response<PostResponseCar>) {
                if(response.isSuccessful) postLDCar.postValue(response.body())
            }
            override fun onFailure(call: Call<PostResponseCar>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun callAPICar(){
        RetrofitClient.instance.getAllCar().enqueue(object  : Callback<List<ResponseDataCarItem>>{
            override fun onResponse(call: Call<List<ResponseDataCarItem>>, response: Response<List<ResponseDataCarItem>>) {
                if(response.isSuccessful){
                    liveDataCar.postValue(response.body())
                }
                //else liveDataCar.postValue(null)
            }
            override fun onFailure(call: Call<List<ResponseDataCarItem>>, t: Throwable) {
                //liveDataCar.postValue(null)
            }

        })
    }
}