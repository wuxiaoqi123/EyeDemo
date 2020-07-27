package com.example.eyedemo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.eyedemo.R
import com.example.eyedemo.event.MessageEvent
import com.example.eyedemo.logic.model.TabEntity
import com.example.eyedemo.ui.common.ui.BaseViewPagerFragment
import com.example.eyedemo.ui.home.discovery.DiscoveryFragment
import com.flyco.tablayout.listener.CustomTabEntity
import kotlinx.android.synthetic.main.layout_main_page_title_bar.*

class HomePageFragment : BaseViewPagerFragment() {

    companion object {
        fun newInstance() = HomePageFragment()
    }

    override val createTitles = ArrayList<CustomTabEntity>().apply {
        add(TabEntity("发现"))
        add(TabEntity("推荐"))
        add(TabEntity("日报"))
    }

    override val createFragments: Array<Fragment> = arrayOf(
        DiscoveryFragment.newInstance(),
        DiscoveryFragment.newInstance(),
        DiscoveryFragment.newInstance()
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(
            inflater.inflate(
                R.layout.fragment_main_container,
                container,
                false
            )
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        ivCalendar.visibility = View.VISIBLE
        viewPager?.currentItem = 1
    }

    override fun onMessageEvent(message: MessageEvent) {
        super.onMessageEvent(message)
    }
}