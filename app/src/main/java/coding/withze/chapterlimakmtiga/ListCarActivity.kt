package coding.withze.chapterlimakmtiga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import coding.withze.chapterlimakmtiga.adapter.CarAdapter
import coding.withze.chapterlimakmtiga.databinding.ActivityListCarBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListCarActivity : AppCompatActivity() {

    lateinit var binding : ActivityListCarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListCarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showDataCar()
    }

    fun showDataCar(){
        RetrofitClient.instance.getAllCar().enqueue(object : Callback<List<ResponseDataCarItem>>{
            override fun onResponse(call: Call<List<ResponseDataCarItem>>, response: Response<List<ResponseDataCarItem>>) {
                if(response.isSuccessful){
                    binding.rvCar.layoutManager = LinearLayoutManager(this@ListCarActivity, LinearLayoutManager.VERTICAL, false)
                    binding.rvCar.adapter = CarAdapter(response.body()!!)
                }
                else{
                    Toast.makeText(this@ListCarActivity, "load data failed", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<ResponseDataCarItem>>, t: Throwable) {
                Toast.makeText(this@ListCarActivity, "jiakh error", Toast.LENGTH_SHORT).show()
            }

        })
    }
}