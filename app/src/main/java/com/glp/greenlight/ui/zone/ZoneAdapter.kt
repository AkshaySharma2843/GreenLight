package com.glp.greenlight.ui.zone

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.glp.greenlight.data.model.SalesZone
import com.glp.greenlight.databinding.ItemViewLayoutBinding

/**
 * Created by Akshay Sharma on 03-08-2022.
 */
class ZoneAdapter(val list:ArrayList<SalesZone>, private val postClickListener: PostClickListener) : RecyclerView.Adapter<ZoneViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZoneViewHolder {
        return  ZoneViewHolder(ItemViewLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ZoneViewHolder, position: Int) {
        val dataToBind = list.get(position)
        holder.bindData(dataToBind,postClickListener)
    }

    override fun getItemCount(): Int = list.size
}