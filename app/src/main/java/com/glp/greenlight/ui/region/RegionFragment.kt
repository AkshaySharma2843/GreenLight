package com.glp.greenlight.ui.region

import androidx.recyclerview.widget.LinearLayoutManager
import com.glp.greenlight.data.model.SalesRegion
import com.glp.greenlight.databinding.FragmentRegionBinding
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
class RegionFragment : BaseFragment<MainViewModel,FragmentRegionBinding>(FragmentRegionBinding::inflate),PostClickListener{


    override fun setupView() {
        ViewUtils.toShowTopBarLiveData.postValue(true)
        getBundleData()
        viewModel.greenLightLiveData.observe(viewLifecycleOwner){
            when(it.status){
                Status.SUCCESS->{
                    renderRv(it.data?.ResponseData?.sales_region)
                }
            }
        }
    }

    private fun getBundleData() {
        arguments?.let {
            val args = RegionFragmentArgs.fromBundle(it)
            (args.regionTitle + " " + "Performance").also { binding.tvPerformance.text = it }
        }
    }

    private fun renderRv(salesRegion: List<SalesRegion>?) {
        val arrayList = ArrayList<SalesRegion>()
        arrayList.addAll(salesRegion!!)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = RegionAdapter(arrayList,this@RegionFragment)
        }

    }

    override fun injectDependencies(fragmentComponent: FragmentComponent) = fragmentComponent.inject(this)

    override fun onRegionClick(salesRegion: SalesRegion, position: Int) {
        goTo(RegionFragmentDirections.actionRegionFragmentToAreaFragment(salesRegion.region))
    }


}