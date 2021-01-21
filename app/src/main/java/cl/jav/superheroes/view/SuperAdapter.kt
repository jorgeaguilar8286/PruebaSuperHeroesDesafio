package cl.jav.superheroes.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.jav.superheroes.databinding.ItemListSuperheroeBinding
import cl.jav.superheroes.model.SuperHero
import coil.load


class SuperAdapter(val listener:OnItemClickListener): RecyclerView.Adapter<SuperVH>() {

    private val superList=mutableListOf<SuperHero>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperVH {
        val binding=ItemListSuperheroeBinding.inflate(LayoutInflater.from(parent.context))
        return SuperVH(binding)
    }

    override fun onBindViewHolder(holder: SuperVH, position: Int) {
        val superHero=superList[position]
        holder.itemView.setOnClickListener{
            listener.onClick(superHero.id)
        }
        holder.bind(superHero)


    }

    override fun getItemCount(): Int {
        return superList.size
    }

    fun updateList(list:List<SuperHero>){
        superList.clear()
        superList.addAll(list)
        notifyDataSetChanged()
    }
}

class SuperVH(private val binding:ItemListSuperheroeBinding):RecyclerView.ViewHolder(binding.root) {

    fun bind(superHero: SuperHero) {
        binding.texvName.text=superHero.name
        binding.imageView2.load(superHero.images.sm)
        binding.texvAlin.text=superHero.biography.alignment.toUpperCase()
        binding.texvIniv.text=superHero.biography.publisher

    }


}