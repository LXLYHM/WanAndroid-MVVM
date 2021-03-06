package com.shehuan.wanandroid.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shehuan.wanandroid.App
import com.shehuan.wanandroid.base.net.exception.ApiException
import com.shehuan.wanandroid.base.net.exception.ExceptionHandler
import com.shehuan.wanandroid.utils.ToastUtil
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {
    protected fun launch(request: suspend () -> Unit, fail: suspend (ApiException) -> Unit) =
        viewModelScope.launch {
            try {
                request()
            } catch (e: Throwable) {
                val exception = ExceptionHandler.handle(e)
                ToastUtil.show(App.getApp(), exception.errorMessage)
                fail(exception)
            }
        }
}