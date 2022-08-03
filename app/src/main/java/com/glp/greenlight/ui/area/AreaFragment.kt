package com.glp.greenlight.ui.area

import androidx.recyclerview.widget.LinearLayoutManager
import com.glp.greenlight.data.model.SalesArea
import com.glp.greenlight.databinding.FragmentAreaBinding
import com.glp.greenlight.di.component.FragmentComponent
import com.glp.greenlight.ui.base.BaseFragment
import com.glp.greenlight.ui.main.MainActivity
import com.glp.greenlight.ui.main.MainViewModel
import com.glp.greenlight.utils.common.Status
import com.glp.greenlight.utils.common.ViewUtils

/**
 * Created by Akshay Sharma on 03-08-2022.
 */
class AreaFragment : BaseFragment<MainViewModel,FragmentAreaBinding>(FragmentAreaBinding::inflate) {

    override fun setupView() {
        ViewUtils.toShowTopBarLiveData.postValue(true)
        getBundledData()
        viewModel.greenLightLiveData.observe(viewLifecycleOwner){
            when(it.status){
                Status.SUCCESS->{
                    renderRv(it.data?.ResponseData?.sales_area)
                }
            }
        }
    }

    private fun getBundledData() {
        arguments?.let {
            (AreaFragmentArgs.fromBundle(it).areaName + " Performance").also { binding.textView.text = it }
        }
    }

    private fun renderRv(salesArea: List<SalesArea>?) {
        val arrayList = ArrayList<SalesArea>()
        arrayList.addAll(salesArea!!)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = AreaAdapter(arrayList)
        }

    }

    override fun injectDependencies(fragmentComponent: FragmentComponent) = fragmentComponent.inject(this)

}