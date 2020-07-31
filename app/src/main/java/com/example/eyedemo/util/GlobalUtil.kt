package com.example.eyedemo.util

import android.annotation.SuppressLint
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Build
import android.provider.Settings
import android.text.TextUtils
import com.example.eyedemo.EyepetizerApplication
import com.example.eyedemo.extension.edit
import com.example.eyedemo.extension.logW
import com.example.eyedemo.extension.sharedPreferences
import java.util.*

object GlobalUtil {

    private var TAG = "GlobalUtil"

    val eyepetizerVersionName: String
        get() = "6.3.01"

    val eyepetizerVersionCode: Long
        get() = 6030012

    val deviceModel: String
        get() {
            var deviceModel = Build.MODEL
            if (TextUtils.isEmpty(deviceModel)) {
                deviceModel = "unknown"
            }
            return deviceModel
        }

    val deviceBrand: String
        get() {
            var deviceBrand = Build.BRAND
            if (TextUtils.isEmpty(deviceBrand)) {
                deviceBrand = "unknown"
            }
            return deviceBrand.toLowerCase(Locale.getDefault())
        }

    val appPackage: String
        get() = EyepetizerApplication.context.packageName

    val appName: String
        get() = EyepetizerApplication.context.resources.getString(EyepetizerApplication.context.applicationInfo.labelRes)

    val appVersionName: String
        get() = EyepetizerApplication.context.packageManager.getPackageInfo(
            appPackage,
            0
        ).versionName

    private var deviceSerial: String? = null

    @SuppressLint("HardwareIds")
    fun getDeviceSerial(): String {
        if (deviceSerial == null) {
            var deviceId: String? = null
            val appChannel = getApplicationMetaData("APP_CHANNEL")
            if ("google" != appChannel || "samsung" != appChannel) {
                try {
                    deviceId = Settings.Secure.getString(
                        EyepetizerApplication.context.contentResolver,
                        Settings.Secure.ANDROID_ID
                    )
                } catch (e: Exception) {
                    logW(TAG, "get android_id with error", e)
                }
                if (!TextUtils.isEmpty(deviceId) && deviceId!!.length < 255) {
                    deviceSerial = deviceId
                    return deviceSerial.toString()
                }
            }
            var uuid = sharedPreferences.getString("uuid", "")
            if (!TextUtils.isEmpty(uuid)) {
                deviceSerial = uuid
                return deviceSerial.toString()
            }
            uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase(Locale.getDefault())
            sharedPreferences.edit { putString("uuid", uuid) }
            deviceSerial = uuid
            return deviceSerial.toString()
        } else {
            return deviceSerial.toString()
        }
    }

    fun getApplicationMetaData(key: String): String? {
        var applicationInfo: ApplicationInfo? = null
        try {
            applicationInfo = EyepetizerApplication.context.packageManager.getApplicationInfo(
                appPackage,
                PackageManager.GET_META_DATA
            )
        } catch (e: PackageManager.NameNotFoundException) {
            logW(TAG, e.message, e)
        }
        if (applicationInfo == null) return ""
        return applicationInfo.metaData.getString(key)
    }

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

    fun getDimension(resId: Int): Int {
        return EyepetizerApplication.context.resources.getDimensionPixelOffset(resId)
    }
}