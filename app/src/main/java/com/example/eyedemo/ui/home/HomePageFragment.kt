package com.example.eyedemo.ui.home

import androidx.fragment.app.Fragment
import com.example.eyedemo.logic.model.TabEntity
import com.example.eyedemo.ui.common.ui.BaseViewPagerFragment
import com.flyco.tablayout.listener.CustomTabEntity

class HomePageFragment : BaseViewPagerFragment() {

    override val createTitles = ArrayList<CustomTabEntity>().apply {
        add(TabEntity("发现"))
        add(TabEntity("推荐"))
        add(TabEntity("日报"))
    }

    override val createFragments: Array<Fragment>
        get() = TODO("Not yet implemented")
}