package coding.withze.chapterlimakmtiga

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelUser : ViewModel() {
    lateinit var liveDataUser : MutableLiveData<List<ResponseDataUserItem>>

    init {
        liveDataUser = MutableLiveData()
    }

    fun ambilLiveDataUser() : MutableLiveData<List<ResponseDataUserItem>>{
        return liveDataUser
    }

    fun callAPIUser(){
        RetrofitClientUser.instance.getAllUser().enqueue(object  : Callback<List<ResponseDataUserItem>>{
            override fun onResponse(call: Call<List<ResponseDataUserItem>>, response: Response<List<ResponseDataUserItem>>) {
                if(response.isSuccessful){
                    liveDataUser.postValue(response.body())
                }
                else {
                }
            }
            override fun onFailure(call: Call<List<ResponseDataUserItem>>, t: Throwable) {

            }

        })
    }
}