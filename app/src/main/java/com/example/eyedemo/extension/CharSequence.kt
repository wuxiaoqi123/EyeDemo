package com.example.eyedemo.extension

import android.widget.Toast
import com.example.eyedemo.EyepetizerApplication
import com.example.eyedemo.ui.common.ui.vassonic.SonicRuntimeImpl
import com.tencent.sonic.sdk.SonicConfig
import com.tencent.sonic.sdk.SonicEngine
import com.tencent.sonic.sdk.SonicSessionConfig

fun CharSequence.showToast(duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(EyepetizerApplication.context, this, duration).show()
}

fun CharSequence.preCreateSession(): Boolean {
    if (!SonicEngine.isGetInstanceAllowed()) {
        SonicEngine.createInstance(
            SonicRuntimeImpl(
                EyepetizerApplication.context
            ),
            SonicConfig.Builder().build()
        )
    }
    val sessionConfigBuilder = SonicSessionConfig.Builder().apply { setSupportLocalServer(true) }
    val preloadSuccess = SonicEngine.getInstance().preCreateSession(this.toString(), sessionConfigBuilder.build())
    logD("preCreateSession()", "${this}\t:${if (preloadSuccess) "Preload start up success!" else "Preload start up fail!"}")
    return preloadSuccess
}