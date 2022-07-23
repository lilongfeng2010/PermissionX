package com.permissionx.mylibrary

import androidx.fragment.app.FragmentActivity

object PermissionX {

    private const val TAG = "PermissionX"
    fun request(
        activity: FragmentActivity,
        vararg permissions: String,
        callback: PermissionCallback
    ) {
        val fragmentManager = activity.supportFragmentManager
        val existedFragment = fragmentManager.findFragmentByTag(TAG)
        val fragment = if (existedFragment != null) {
            existedFragment as InVisibleFragment
        } else {
            val inVisibleFragment = InVisibleFragment()
            fragmentManager.beginTransaction().add(inVisibleFragment, TAG).commitNow()
            inVisibleFragment
        }
        fragment.requestNow(callback, *permissions)
    }
}