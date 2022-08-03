package com.glp.greenlight.ui.zone

import androidx.recyclerview.widget.LinearLayoutManager
import com.glp.greenlight.data.model.SalesZone
import com.glp.greenlight.databinding.FragmentZoneBinding
import com.glp.greenlight.di.component.FragmentComponent
import com.glp.greenlight.ui.base.BaseFragment
import com.glp.greenlight.ui.main.MainActivity
import com.glp.greenlight.ui.main.MainViewModel
import com.glp.greenlight.ui.region.RegionFragmentDirections
import com.glp.greenlight.utils.common.Status
import com.glp.greenlight.utils.common.ViewUtils.toShowTopBarLiveData
import com.glp.greenlight.utils.common.goTo

/**
 * Created by Akshay Sharma on 03-08-2022.
 */
class ZoneFragment : BaseFragment<MainViewModel,FragmentZoneBinding>(FragmentZoneBinding::inflate),PostClickListener{
    override fun setupView() {
        toShowTopBarLiveData.postValue(true)
        getBundleData()
        viewModel.greenLightLiveData.observe(viewLifecycleOwner){
            when(it.status){
                Status.SUCCESS->{
                    renderRecyclerView(it.data?.ResponseData?.sales_zone)
                }
            }
        }
    }

    private fun getBundleData() {
        arguments?.let {
            (ZoneFragmentArgs.fromBundle(it).countryName+ " Performance").also { binding.textView.text = it }
        }
    }

    private fun renderRecyclerView(salesZone: List<SalesZone>?) {

        val arrayList = ArrayList<SalesZone>()
        arrayList.addAll(salesZone!!)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            adapter = ZoneAdapter(arrayList,this@ZoneFragment)
        }
    }

    override fun injectDependencies(fragmentComponent: FragmentComponent) = fragmentComponent.inject(this)
    override fun onZoneClick(salesZone: SalesZone) {
        goTo(ZoneFragmentDirections.actionZoneFragmentToRegionFragment(salesZone.zone))
    }

}