package com.example.simplemvvm.util

import android.content.Context
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit


fun AppCompatActivity.addFragment(
    @IdRes containerViewId: Int,
    context: Context?,
    fragment: Fragment,
    tag: String,
    addToBackStack: Boolean
) {
    if (context == null) {
        return
    }
    val fragmentManager = (context as AppCompatActivity).supportFragmentManager
    fragmentManager.commit {
        setReorderingAllowed(true)
        add(containerViewId, fragment, tag)
        if (addToBackStack) {
            addToBackStack(tag)
        }
    }
}

fun FragmentActivity.addFragment(
    @IdRes containerViewId: Int,
    context: Context?,
    fragment: Fragment,
    tag: String,
    addToBackStack: Boolean
) {
    if (context == null) {
        return
    }
    val fragmentManager = (context as AppCompatActivity).supportFragmentManager
    fragmentManager.commit {
        setReorderingAllowed(true)
        replace(containerViewId, fragment, tag)
        if (addToBackStack) {
            addToBackStack(tag)
        }
    }
}