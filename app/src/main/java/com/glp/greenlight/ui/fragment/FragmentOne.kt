package com.glp.greenlight.ui.fragment

import com.glp.greenlight.databinding.FragmentMainBinding
import com.glp.greenlight.di.component.FragmentComponent
import com.glp.greenlight.ui.base.BaseFragment
import com.glp.greenlight.ui.main.MainActivity
import com.glp.greenlight.ui.main.MainViewModel
import com.glp.greenlight.utils.common.ViewUtils
import com.glp.greenlight.utils.common.goTo

/**
 * Created by Akshay Sharma on 03-08-2022.
 */
class FragmentOne : BaseFragment<MainViewModel,FragmentMainBinding>(FragmentMainBinding::inflate) {
    override fun setupView() {
        ViewUtils.toShowTopBarLiveData.postValue(false)
        binding.ivPlay.setOnClickListener {
            goTo(FragmentOneDirections.actionFragmentOneToFragmentTwo())
        }
    }

    override fun injectDependencies(fragmentComponent: FragmentComponent) = fragmentComponent.inject(this)
}