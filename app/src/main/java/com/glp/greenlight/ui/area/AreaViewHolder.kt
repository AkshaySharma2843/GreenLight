package com.glp.greenlight.ui.area

import androidx.recyclerview.widget.RecyclerView
import com.glp.greenlight.data.model.SalesArea
import com.glp.greenlight.databinding.ItemViewLayoutBinding

/**
 * Created by Akshay Sharma on 03-08-2022.
 */
class AreaViewHolder(private val itemViewLayoutBinding: ItemViewLayoutBinding) :RecyclerView.ViewHolder(itemViewLayoutBinding.root) {
    fun bindData(dataToBind: SalesArea) {
        itemViewLayoutBinding.tvName.text = dataToBind.area


    }

}