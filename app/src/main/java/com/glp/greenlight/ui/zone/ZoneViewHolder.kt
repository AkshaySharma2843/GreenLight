package com.glp.greenlight.ui.zone

import androidx.recyclerview.widget.RecyclerView
import com.glp.greenlight.data.model.SalesZone
import com.glp.greenlight.databinding.ItemViewLayoutBinding

/**
 * Created by Akshay Sharma on 03-08-2022.
 */
class ZoneViewHolder(private val itemViewLayoutBinding: ItemViewLayoutBinding) : RecyclerView.ViewHolder(itemViewLayoutBinding.root){
    fun bindData(dataToBind: SalesZone, postClickListener: PostClickListener) {
        itemViewLayoutBinding.tvName.text = dataToBind.zone
        itemView.setOnClickListener {
            postClickListener.onZoneClick(dataToBind)
        }


    }


}