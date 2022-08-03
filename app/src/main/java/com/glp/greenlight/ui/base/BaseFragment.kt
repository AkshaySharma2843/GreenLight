package com.glp.greenlight.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.glp.greenlight.GreenLightApplication
import com.glp.greenlight.di.component.DaggerFragmentComponent
import com.glp.greenlight.di.component.FragmentComponent
import com.glp.greenlight.di.module.FragmentModule
import javax.inject.Inject

/**
 * Created by Akshay Sharma on 03-08-2022.
 */
private typealias FragmentViewBindingInflater<VB> = (
    inflater: LayoutInflater,
    parent: ViewGroup?,
    attachToParent: Boolean
) -> VB

abstract class BaseFragment<VM : BaseViewModel, VB : ViewBinding>(
    private val bindingInflater: FragmentViewBindingInflater<VB>
) : Fragment() {

    @Inject
    lateinit var viewModel : VM

    private var _binding : VB? = null
    val binding : VB
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildFragmentComponent())
        super.onCreate(savedInstanceState)
    }
    private fun buildFragmentComponent() =
        DaggerFragmentComponent
            .builder()
            .applicationComponent((requireContext().applicationContext as GreenLightApplication).applicationComponent)
            .fragmentModule(FragmentModule(this))
            .build()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }


    abstract fun setupView()
    protected abstract fun injectDependencies(fragmentComponent: FragmentComponent)

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}