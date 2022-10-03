package coding.withze.chapterlimakmtiga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import coding.withze.chapterlimakmtiga.databinding.ActivityAddCarBinding
import coding.withze.chapterlimakmtiga.databinding.ActivityUserBinding

class AddCarActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddCarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddCarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            var name = binding.editTxtName.text.toString()
            var cat = binding.editTxtCategory.text.toString()
            var price = binding.editTxtPrice.text.toString()
            var status = binding.editTxtStatus.text.toString()
            var img = binding.editTxtImage.text.toString()
            addCar(name, cat, price.toInt(), status.toBoolean(), img)
        }
    }

    fun addCar(name:String, category : String, price : Int, status : Boolean, image : String){
        var viewModel = ViewModelProvider(this).get(ViewModelCar::class.java)
        viewModel.callPostAPICar(name, category, price, status, image)
        viewModel.addLiveDataCar().observe(this, {
            if(it!=null){
                Toast.makeText(this, "ADD DATA SUCCESS!", Toast.LENGTH_SHORT).show()
            }
        })
    }
}