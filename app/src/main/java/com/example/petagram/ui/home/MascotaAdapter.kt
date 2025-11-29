// ui/home/MascotaAdapter.kt
package com.example.petagram.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.petagram.data.Mascota
import com.example.petagram.databinding.ItemMascotaBinding

class MascotaAdapter(private val items: List<Mascota>) :
    RecyclerView.Adapter<MascotaAdapter.VH>() {

    class VH(val binding: ItemMascotaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemMascotaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]
        holder.binding.ivMascota.setImageResource(item.imagenRes)
        holder.binding.tvNombre.text = item.nombre
        holder.binding.tvRait.text = "${item.rait} 🦴"
    }

    override fun getItemCount() = items.size
}
