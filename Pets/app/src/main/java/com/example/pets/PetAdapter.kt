package com.example.pets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.pets.databinding.ItemAnimalBinding

class PetAdapter(
    private var list: List<Animal>,
    private val glide: RequestManager,
    private val onItemClick: (Animal) -> Unit,
) : RecyclerView.Adapter<AnimalHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AnimalHolder = AnimalHolder(
        binding = ItemAnimalBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide,
        onItemClick = onItemClick
    )

    override fun onBindViewHolder(
        holder: AnimalHolder,
        position: Int
    ) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun updateData(newList: List<Animal>) {
        list = newList
        notifyDataSetChanged()
    }
}