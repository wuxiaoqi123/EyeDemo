package com.example.eyedemo.ui.common.callback

interface RequestLifecycle {

    fun startLoading()

    fun loadFinished()

    fun loadFailed(msg: String?)
}