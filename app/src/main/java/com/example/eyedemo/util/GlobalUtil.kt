package com.example.eyedemo.util

import com.example.eyedemo.EyepetizerApplication

object GlobalUtil {

    private var TAG = "GlobalUtil"

    val appPackage: String
        get() = EyepetizerApplication.context.packageName

    val appName: String
        get() = EyepetizerApplication.context.resources.getString(EyepetizerApplication.context.applicationInfo.labelRes)

    val appVersionName: String
        get() = EyepetizerApplication.context.packageManager.getPackageInfo(
            appPackage,
            0
        ).versionName
}