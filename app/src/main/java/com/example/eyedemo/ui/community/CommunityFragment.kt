package com.example.eyedemo.ui.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.eyedemo.R
import com.example.eyedemo.event.MessageEvent
import com.example.eyedemo.logic.model.TabEntity
import com.example.eyedemo.ui.common.ui.BaseViewPagerFragment
import com.flyco.tablayout.listener.CustomTabEntity

class CommunityFragment : BaseViewPagerFragment() {

    companion object {
        fun newInstance() = CommunityFragment()
    }

    override val createTitles = ArrayList<CustomTabEntity>().apply {
        add(TabEntity("推荐"))
        add(TabEntity("关注"))
    }

    override val createFragments: Array<Fragment> = arrayOf()

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

    override fun onMessageEvent(message: MessageEvent) {
        super.onMessageEvent(message)
    }

}