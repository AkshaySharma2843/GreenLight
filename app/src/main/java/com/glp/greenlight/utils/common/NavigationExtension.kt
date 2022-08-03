package com.glp.greenlight.utils.common

import android.app.Activity
import androidx.navigation.findNavController

import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController

/**
 * Created by Akshay Sharma on 03-08-2022.
 */
private fun Fragment.safeNavigate(directions: NavDirections) {
    if (mayNavigate) findNavController().navigate(directions)
}

private const val NAV_DESTINATION_ID = 123987465

private val Fragment.mayNavigate: Boolean
    get() {
        val navControllerDestination = findNavController().currentDestination?.id
        val fragmentDestination = view?.getTag(NAV_DESTINATION_ID) ?: navControllerDestination

        return if (navControllerDestination == fragmentDestination) {
            view?.setTag(NAV_DESTINATION_ID, fragmentDestination)
            true
        } else {
            false
        }
    }

fun Fragment.goTo(directions: NavDirections) = safeNavigate(directions)

fun Activity.popBackStack(view : Int) = findNavController(view).popBackStack()