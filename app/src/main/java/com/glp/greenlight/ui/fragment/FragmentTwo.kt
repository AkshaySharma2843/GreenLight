package com.glp.greenlight.ui.fragment

import com.glp.greenlight.data.model.SalesCountry
import com.glp.greenlight.databinding.FragmentTwoBinding
import com.glp.greenlight.di.component.FragmentComponent
import com.glp.greenlight.ui.base.BaseFragment
import com.glp.greenlight.ui.main.MainActivity
import com.glp.greenlight.ui.main.MainViewModel
import com.glp.greenlight.utils.common.Status
import com.glp.greenlight.utils.common.ViewUtils
import com.glp.greenlight.utils.common.goTo

/**
 * Created by Akshay Sharma on 03-08-2022.
 */
class FragmentTwo :BaseFragment<MainViewModel,FragmentTwoBinding>(FragmentTwoBinding::inflate){

    var countryName : String = ""

    override fun setupView() {
        ViewUtils.toShowTopBarLiveData.postValue(true)
        viewModel.greenLightLiveData.observe(viewLifecycleOwner){
            when(it.status){
                Status.SUCCESS -> {
                   countryName = it.data?.ResponseData?.sales_country?.first()?.country.toString()
                }
            }
        }
        binding.tvNext.setOnClickListener {
            goTo(FragmentTwoDirections.actionFragmentTwoToZoneFragment(countryName))
        }
    }

    override fun injectDependencies(fragmentComponent: FragmentComponent) = fragmentComponent.inject(this)


}