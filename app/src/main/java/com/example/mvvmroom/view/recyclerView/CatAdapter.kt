package com.example.mvvmroom.view.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmroom.databinding.CatBinding
import com.example.mvvmroom.model.room.Cat

class CatAdapter(var cats: List<CatData>) : RecyclerView.Adapter<CatAdapter.CatViewHolder>() {

    class CatViewHolder(val binding: CatBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val binding = CatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatViewHolder(binding)
    }

    override fun getItemCount(): Int = cats.size

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        with(holder) {
            with(cats[position]) {
                binding.tvBreed.text = breed
                binding.tvOrigin.text = origin
                binding.tvPattern.text = pattern
            }
        }
    }

    fun updateData(newCatList: List<CatData>) {
        cats = newCatList
    }
}