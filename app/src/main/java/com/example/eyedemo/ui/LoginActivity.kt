package com.example.eyedemo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.eyedemo.ui.common.ui.BaseActivity

class LoginActivity : BaseActivity() {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, LoginActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}