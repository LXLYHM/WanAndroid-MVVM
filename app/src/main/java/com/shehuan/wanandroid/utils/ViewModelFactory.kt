package com.shehuan.wanandroid.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.shehuan.wanandroid.base.BaseRepository
import com.shehuan.wanandroid.base.BaseViewModel

/**
 * Author: shehuan
 * Date: 2019/12/12 14:19
 * Description:
 */

/**
 * 在Activity中初始化viewModel
 */
@Suppress("UNCHECKED_CAST")
fun <BVM : BaseViewModel> initViewModel(
    activity: FragmentActivity,
    vmClass: Class<BVM>,
    rClass: Class<out BaseRepository>
) =
    ViewModelProviders.of(activity, object : ViewModelProvider.NewInstanceFactory() {
        override fun <VM : ViewModel> create(modelClass: Class<VM>): VM {
            return vmClass.getConstructor(rClass).newInstance(rClass.newInstance()) as VM
        }
    }).get(vmClass)


/**
 * 在Fragment中初始化viewModel
 */
@Suppress("UNCHECKED_CAST")
fun <BVM : BaseViewModel> initViewModel(
    fragment: Fragment,
    vmClass: Class<BVM>,
    rClass: Class<out BaseRepository>
) =
    ViewModelProviders.of(fragment, object : ViewModelProvider.NewInstanceFactory() {
        override fun <VM : ViewModel> create(modelClass: Class<VM>): VM {
            return vmClass.getConstructor(rClass).newInstance(rClass.newInstance()) as VM
        }
    }).get(vmClass)