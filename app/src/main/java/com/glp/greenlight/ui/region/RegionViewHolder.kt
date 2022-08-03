package com.glp.greenlight.ui.region

import androidx.recyclerview.widget.RecyclerView
import com.glp.greenlight.data.model.SalesRegion
import com.glp.greenlight.databinding.ItemViewLayoutBinding

/**
 * Created by Akshay Sharma on 03-08-2022.
 */
class RegionViewHolder(private val itemViewLayoutBinding: ItemViewLayoutBinding) : RecyclerView.ViewHolder(itemViewLayoutBinding.root) {
    fun bindData(dataToBind: SalesRegion, postClickListener: PostClickListener, position: Int) {
        itemViewLayoutBinding.tvName.text = dataToBind.region
        itemView.setOnClickListener {
            postClickListener.onRegionClick(dataToBind,position)
        }


    }
}