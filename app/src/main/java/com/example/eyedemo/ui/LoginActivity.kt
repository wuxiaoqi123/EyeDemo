package com.example.eyedemo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.eyedemo.Const
import com.example.eyedemo.R
import com.example.eyedemo.extension.*
import com.example.eyedemo.ui.common.ui.BaseActivity
import com.example.eyedemo.ui.common.ui.WebViewActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.layout_title_bar.*

class LoginActivity : BaseActivity() {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, LoginActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setStatusBarBackground(R.color.black)
    }

    override fun setupViews() {
        super.setupViews()
        initTitleBar()
        initListener()
    }

    private fun initTitleBar() {
        titleBar.layoutParams.height =
            resources.getDimensionPixelSize(R.dimen.actionBarSizeSecondary)
        titleBar.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent))
        val padding = dp2px(9f)
        ivNavigateBefore.setPadding(padding, padding, padding, padding)
        ivNavigateBefore.setImageResource(R.drawable.ic_close_white_24dp)
        tvRightText.visible()
        tvRightText.text = "找回密码"
        tvRightText.setTextColor(ContextCompat.getColor(this@LoginActivity, R.color.white))
        tvRightText.textSize = 12f
        etPhoneNumberOrEmail.setDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.ic_person_white_18dp
            ), 18f, 18f, 0
        )
        etPassWord.setDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.ic_password_white_lock_18dp
            ), 18f, 18f, 0
        )
        divider.gone()
    }

    private fun initListener() {
        setOnClickListener(
            tvRightText,
            tvUserLogin,
            tvUserRegister,
            tvAuthorLogin,
            tvUserAgreement,
            tvUserLogin,
            ivWechat,
            ivSina,
            ivQQ
        ) {
            when (this) {
                tvRightText -> {
                    WebViewActivity.start(
                        this@LoginActivity,
                        WebViewActivity.DEFAULT_TITLE,
                        Const.Url.FORGET_PASSWORD,
                        false,
                        false
                    )
                }
                tvUserRegister -> {
                    WebViewActivity.start(
                        this@LoginActivity,
                        WebViewActivity.DEFAULT_TITLE,
                        Const.Url.AUTHOR_REGISTER,
                        false,
                        false
                    )
                }
                tvAuthorLogin -> {
                    WebViewActivity.start(
                        this@LoginActivity,
                        WebViewActivity.DEFAULT_TITLE,
                        Const.Url.AUTHOR_LOGIN,
                        false,
                        false
                    )
                }
                tvUserAgreement -> {
                    WebViewActivity.start(
                        this@LoginActivity,
                        WebViewActivity.DEFAULT_TITLE,
                        Const.Url.USER_AGREEMENT,
                        false,
                        false
                    )
                }
                tvUserLogin, ivWechat, ivSina, ivQQ -> {
                    R.string.currently_not_supported.showToast()
                }
                else -> {
                }
            }
        }
    }
}