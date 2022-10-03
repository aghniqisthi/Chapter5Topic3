package coding.withze.chapterlimakmtiga.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coding.withze.chapterlimakmtiga.ResponseDataUserItem
import coding.withze.chapterlimakmtiga.databinding.ItemUserBinding

class UserAdapter(var listUser : List<ResponseDataUserItem>):RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(var binding : ItemUserBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        var view = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        holder.binding.txtNameUser.text = listUser[position].name
        holder.binding.txtAgeUser.text = listUser[position].age.toString()
    }

    override fun getItemCount(): Int  = listUser.size

}