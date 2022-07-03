package com.example.pets

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.pets.databinding.ItemAnimalBinding

class AnimalHolder (
    private val binding: ItemAnimalBinding,
    private val glide: RequestManager,
    private val onItemClick: (Animal) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    private val options: RequestOptions = RequestOptions()
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)

    fun onBind(song: Animal) {
        with(binding) {
            tvName.text = song.name
            tvSpecies.text = song.species
            root.setOnClickListener {
                onItemClick(song)
            }

            glide
                .load(song.url)
                .placeholder(R.drawable.dog2)
                .error(R.drawable.dog2)
                .into(ivCover)
        }
    }
}