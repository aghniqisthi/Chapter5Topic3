package coding.withze.chapterlimakmtiga

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelCar : ViewModel() {

    lateinit var liveDataCar : MutableLiveData<List<ResponseDataCarItem>>
    lateinit var postLDCar : MutableLiveData<PostResponseCar>

    init {
        liveDataCar = MutableLiveData()
        postLDCar = MutableLiveData()
    }

    fun ambilLiveDataCar() : MutableLiveData<List<ResponseDataCarItem>>{
        return liveDataCar
    }

    fun addLiveDataCar() : MutableLiveData<PostResponseCar>{
        return postLDCar
    }

    fun callPostAPICar(name:String, category:String, price:Int, status:Boolean, image:String){
        RetrofitClient.instance.addCar(DataCar(name, category, price, status, image)).enqueue(object :Callback<List<PostResponseCar>>){

        }
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