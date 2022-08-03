package com.glp.greenlight.ui.region

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.glp.greenlight.data.model.SalesRegion
import com.glp.greenlight.databinding.ItemViewLayoutBinding

/**
 * Created by Akshay Sharma on 03-08-2022.
 */
class RegionAdapter(private val list :ArrayList<SalesRegion>,private val postClickListener: PostClickListener) :RecyclerView.Adapter<RegionViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegionViewHolder {
        return RegionViewHolder(ItemViewLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RegionViewHolder, position: Int) {
        val dataToBind = list.get(position)
        holder.bindData(dataToBind,postClickListener,position)
    }

    override fun getItemCount(): Int = list.size

}