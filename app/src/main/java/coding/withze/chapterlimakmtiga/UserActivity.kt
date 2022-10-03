package coding.withze.chapterlimakmtiga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import coding.withze.chapterlimakmtiga.adapter.UserAdapter
import coding.withze.chapterlimakmtiga.databinding.ActivityUserBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserActivity : AppCompatActivity() {

    lateinit var binding : ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showDataUser()
    }

    fun showDataUser(){
        val vmUser = ViewModelProvider(this).get(ViewModelUser::class.java)

        vmUser.callAPIUser()
        vmUser.ambilLiveDataUser().observe(this, {
            if(it != null){
                binding.rvUser.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.rvUser.adapter = UserAdapter(it)
            }
        })
    }
}