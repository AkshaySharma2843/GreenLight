package com.glp.greenlight.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.glp.greenlight.R
import com.glp.greenlight.databinding.ActivityMainBinding
import com.glp.greenlight.di.component.ActivityComponent
import com.glp.greenlight.ui.base.BaseActivity
import com.glp.greenlight.utils.common.ViewUtils
import com.glp.greenlight.utils.common.popBackStack

class MainActivity : BaseActivity<MainViewModel,ActivityMainBinding>(ActivityMainBinding::inflate), View.OnClickListener{


    override fun injectDependencies(activityComponent: ActivityComponent) = activityComponent.inject(this)

    override fun setupView(savedInstanceState: Bundle?) {
        binding.ivBack.setOnClickListener(this)
        observeViewTopBar()

    }

    private fun observeViewTopBar() {
        ViewUtils.toShowTopBarLiveData.observe(this){
            if(it) showTopBar() else hideTopBar()
        }
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.iv_back -> {
                popUpFragments()
            }
        }
    }

    private fun popUpFragments() {
        popBackStack(R.id.navigation)
    }

   private fun hideTopBar() {
        binding.constraintLayout.visibility = View.GONE
    }

  private  fun showTopBar() {
        binding.constraintLayout.visibility = View.VISIBLE
    }

}