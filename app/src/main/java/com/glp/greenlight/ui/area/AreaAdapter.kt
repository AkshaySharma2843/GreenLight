package com.glp.greenlight.ui.area

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.glp.greenlight.data.model.SalesArea
import com.glp.greenlight.databinding.ItemViewLayoutBinding

/**
 * Created by Akshay Sharma on 03-08-2022.
 */
class AreaAdapter(private val list: ArrayList<SalesArea>):RecyclerView.Adapter<AreaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AreaViewHolder {
        return AreaViewHolder(ItemViewLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: AreaViewHolder, position: Int) {
        val dataToBind = list.get(position)
        holder.bindData(dataToBind)
    }

    override fun getItemCount(): Int = list.size
}