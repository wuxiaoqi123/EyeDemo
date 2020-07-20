package com.example.eyedemo.ui

import android.Manifest
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import com.example.eyedemo.MainActivity
import com.example.eyedemo.R
import com.example.eyedemo.extension.edit
import com.example.eyedemo.extension.sharedPreferences
import com.example.eyedemo.ui.common.ui.BaseActivity
import com.permissionx.guolindev.PermissionX
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : BaseActivity() {

    companion object {
        var isFirstEntryApp: Boolean
            get() = sharedPreferences.getBoolean("is_first_entry_app", true)
            set(value) = sharedPreferences.edit { putBoolean("is_first_entry_app", value) }
    }

    private val job by lazy { Job() }

    private val splashDuration = 3 * 1000L

    private val alphaAnimation by lazy {
        AlphaAnimation(0.5f, 1.0f).apply {
            duration = splashDuration
            fillAfter = true
        }
    }

    private val scaleAnimation by lazy {
        ScaleAnimation(
            1.0f,
            1.05f,
            1f,
            1.05f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        ).apply {
            duration = splashDuration
            fillAfter = true
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWriteExternalStoragePersmission()
    }

    private fun requestWriteExternalStoragePersmission() {
        PermissionX.init(this).permissions(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            .onExplainRequestReason { scope, deniedList ->
                val messages = "需要存储权限来处理您的图片信息"
                scope.showRequestReasonDialog(deniedList, messages, "确定", "取消")
            }
            .onForwardToSettings { scope, deniedList ->
                val message = "需要存储权限来处理您的图片信息"
                scope.showForwardToSettingsDialog(deniedList, message, "设置", "取消")
            }
            .request { allGranted, grantedList, deniedList ->
                requestReadPhoneStatePermission()
            }
    }

    private fun requestReadPhoneStatePermission() {
        PermissionX.init(this).permissions(Manifest.permission.READ_PHONE_STATE)
            .onExplainRequestReason { scope, deniedList ->
                val message = "开眼视频推荐和观看记录等功能，需要访问手机识别码等信息"
                scope.showRequestReasonDialog(deniedList, message, "确定", "取消")
            }
            .onForwardToSettings { scope, deniedList ->
                val message = "开眼视频推荐和观看记录等功能，需要访问手机识别码等信息"
                scope.showForwardToSettingsDialog(deniedList, message, "设置", "取消")
            }
            .request { allGranted, grantedList, deniedList ->
                setContentView(R.layout.activity_splash)
            }
    }

    override fun setupViews() {
        super.setupViews()
        ivSlogan.startAnimation(alphaAnimation)
        ivSplashPicture.startAnimation(scaleAnimation)
        CoroutineScope(job).launch {
            delay(splashDuration)
            MainActivity.start(this@SplashActivity)
            finish()
        }
        isFirstEntryApp = false
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}