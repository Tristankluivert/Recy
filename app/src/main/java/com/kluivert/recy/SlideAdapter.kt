package com.kluivert.recy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.slides_layout.view.*

class SlideAdapter(
    var sliders : List<Sliders>

) : RecyclerView.Adapter<SlideAdapter.SliderViewHolder>(){

    inner class SliderViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.slides_layout,parent,false)
        return SliderViewHolder(view)
    }

    override fun getItemCount(): Int {
       return sliders.size
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {

        holder.itemView.apply {
            txTitle.text = sliders[position].title
            txDesc.text = sliders[position].desc
            val img = sliders[position].img
            ivSlide.setImageResource(img)
        }

    }
}