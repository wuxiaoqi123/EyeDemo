package com.example.eyedemo.logic.model

import com.flyco.tablayout.listener.CustomTabEntity

class TabEntity(
    private var title: String,
    private var selectedIcon: Int = 0,
    private var unSelectedIcon: Int = 0
) : CustomTabEntity {

    override fun getTabUnselectedIcon() = unSelectedIcon

    override fun getTabSelectedIcon() = selectedIcon

    override fun getTabTitle() = title
}