package com.example.eyedemo.util

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
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

    fun getString(res: Int): String = EyepetizerApplication.context.getString(res)

    fun isInstalled(packageName: String): Boolean {
        val packageInfo: PackageInfo? = try {
            EyepetizerApplication.context.packageManager.getPackageInfo(packageName, 0)
        } catch (e: PackageManager.NameNotFoundException) {
            null
        }
        return packageInfo != null
    }

    fun isQQInstalled() = isInstalled("com.tencent.mobileqq")

    fun isWechatInstalled() = isInstalled("com.tencent.mm")

    fun isWeiboInstalled() = isInstalled("com.sina.weibo")
}