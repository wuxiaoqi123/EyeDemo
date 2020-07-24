package com.example.eyedemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.eyedemo.event.RefreshEvent
import com.example.eyedemo.extension.setOnClickListener
import com.example.eyedemo.ui.common.ui.BaseActivity
import com.example.eyedemo.ui.community.CommunityFragment
import com.example.eyedemo.ui.home.HomePageFragment
import com.example.eyedemo.ui.mine.MineFragment
import com.example.eyedemo.ui.notification.NotificationFragment
import kotlinx.android.synthetic.main.layout_bottom_navigation_bar.*
import org.greenrobot.eventbus.EventBus

class MainActivity : BaseActivity() {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    private var backPressTime = 0L

    private var homePageFragment: HomePageFragment? = null

    private var communityFragment: CommunityFragment? = null

    private var notificationFragment: NotificationFragment? = null

    private var mineFragment: MineFragment? = null

    private val fragmentManager: FragmentManager by lazy { supportFragmentManager }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun setupViews() {
        observe()
        setOnClickListener(btnHomePage, btnCommunity, btnNotification, btnMine) {
            when (this) {
                btnHomePage -> {
                    notificationUiRefresh(0)
                    setTabSelection(0)
                }
                btnCommunity -> {
                    notificationUiRefresh(1)
                    setTabSelection(1)
                }
                btnNotification -> {
                    notificationUiRefresh(2)
                    setTabSelection(2)
                }
                btnMine -> {
                    notificationUiRefresh(3)
                    setTabSelection(3)
                }
            }
        }
        setTabSelection(0)
    }

    private fun observe() {

    }

    private fun notificationUiRefresh(selectionIndex: Int) {
        when (selectionIndex) {
            0 -> {
                if (ivHomePage.isSelected) {
                    EventBus.getDefault().post(RefreshEvent(HomePageFragment::class.java))
                }
            }
            1 -> {
                if (ivCommunity.isSelected) {
                    EventBus.getDefault().post(RefreshEvent(CommunityFragment::class.java))
                }
            }
            2 -> {
                if (ivNotification.isSelected) {
                    EventBus.getDefault().post(RefreshEvent(NotificationFragment::class.java))
                }
            }
            3 -> {
                if (ivMine.isSelected) {
                    EventBus.getDefault().post(RefreshEvent(MineFragment::class.java))
                }
            }
        }
    }

    private fun setTabSelection(index: Int) {
        clearAllSelected()
        fragmentManager.beginTransaction().apply {
            hideFragments(this)
            when (index) {
                0 -> {
                    ivHomePage.isSelected = true
                    tvHomePage.isSelected = true
                    if (homePageFragment == null) {
                        homePageFragment = HomePageFragment.newInstance()
                        add(R.id.homeActivityFragContainer, homePageFragment!!)
                    } else {
                        show(homePageFragment!!)
                    }
                }
                1 -> {
                    ivCommunity.isSelected = true
                    tvCommunity.isSelected = true
                    if (communityFragment == null) {
                        communityFragment = CommunityFragment.newInstance()
                        add(R.id.homeActivityFragContainer, communityFragment!!)
                    } else {
                        show(communityFragment!!)
                    }
                }
                2 -> {
                    ivNotification.isSelected = true
                    tvNotification.isSelected = true
                    if (notificationFragment == null) {
                        notificationFragment = NotificationFragment.newInstance()
                        add(R.id.homeActivityFragContainer, notificationFragment!!)
                    } else {
                        show(notificationFragment!!)
                    }
                }
                3 -> {
                    ivMine.isSelected = true
                    tvMine.isSelected = true
                    if (mineFragment == null) {
                        mineFragment = MineFragment.newInstance()
                        add(R.id.homeActivityFragContainer, mineFragment!!)
                    } else {
                        show(mineFragment!!)
                    }
                }
                else -> {
                    ivHomePage.isSelected = true
                    tvHomePage.isSelected = true
                    if (homePageFragment == null) {
                        homePageFragment = HomePageFragment.newInstance()
                        add(R.id.homeActivityFragContainer, homePageFragment!!)
                    } else {
                        show(homePageFragment!!)
                    }
                }
            }
        }.commitAllowingStateLoss()
    }

    private fun clearAllSelected() {
        ivHomePage.isSelected = false
        tvHomePage.isSelected = false
        ivCommunity.isSelected = false
        tvCommunity.isSelected = false
        ivNotification.isSelected = false
        tvNotification.isSelected = false
        ivMine.isSelected = false
        tvMine.isSelected = false
    }

    private fun hideFragments(transaction: FragmentTransaction) {
        transaction.run {
            homePageFragment?.let { hide(it) }
            communityFragment?.let { hide(it) }
            notificationFragment?.let { hide(it) }
            mineFragment?.let { hide(it) }
        }
    }
}