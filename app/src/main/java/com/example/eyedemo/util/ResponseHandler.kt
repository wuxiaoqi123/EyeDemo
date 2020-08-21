package com.example.eyedemo.util

import com.example.eyedemo.extension.logW
import com.example.eyedemo.ui.common.exception.ResponseCodeException
import com.google.gson.JsonSyntaxException
import java.net.ConnectException
import java.net.NoRouteToHostException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

object ResponseHandler {

    private const val TAG = "ResponseHandler"

    fun getFailureTips(e: Throwable?): String {
        logW(TAG, "getFailureTips exception is ${e?.message}")
        return when (e) {
            is ConnectException -> "网络连接异常"
            is SocketTimeoutException -> "网络连接超时"
            is ResponseCodeException -> "服务器状态码异常：" + e.responseCode
            is NoRouteToHostException -> "无法连接到服务器"
            is UnknownHostException -> "网络错误"
            is JsonSyntaxException -> "数据解析异常"
            else -> {
                "发生未知错误"
            }

        }
    }
}