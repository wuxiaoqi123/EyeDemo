package com.example.eyedemo.ui.common.ui

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import com.example.eyedemo.R
import com.example.eyedemo.event.MessageEvent
import com.example.eyedemo.extension.logD
import com.example.eyedemo.ui.common.callback.RequestLifecycle
import com.example.eyedemo.util.ShareUtil
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

open class BaseFragment : Fragment(), RequestLifecycle {

    private var mHasLoadedData = false

    private var loadErrorView: View? = null

    protected var rootView: View? = null

    protected var loading: ProgressBar? = null

    lateinit var activity: Activity

    protected val TAG: String = this.javaClass.simpleName

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = getActivity()!!
        logD(TAG, "BaseFragment-->onAttach()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logD(TAG, "BaseFragment-->onCreate()")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        logD(TAG, "BaseFragment-->onCreateView()")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logD(TAG, "BaseFragment-->onViewCreated()")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        logD(TAG, "BaseFragment-->onActivityCreated()")
    }

    override fun onStart() {
        super.onStart()
        logD(TAG, "BaseFragment-->onStart()")
    }

    override fun onResume() {
        super.onResume()
        logD(TAG, "BaseFragment-->onResume()")
        if (!mHasLoadedData) {
            loadDataOnce()
            logD(TAG, "BaseFragment-->loadDataOnce()")
            mHasLoadedData = true
        }
    }

    override fun onPause() {
        super.onPause()
        logD(TAG, "BaseFragment-->onPause()")
    }

    override fun onStop() {
        super.onStop()
        logD(TAG, "BaseFragment-->onStop()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        logD(TAG, "BaseFragment-->onDestroyView()")
        EventBus.getDefault().unregister(this)
        if (rootView?.parent != null) {
            (rootView?.parent as ViewGroup).removeView(rootView)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        logD(TAG, "BaseFragment-->onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        logD(TAG, "BaseFragment-->onDetach()")
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    open fun onMessageEvent(message: MessageEvent) {
        logD(TAG, "BaseFragment-->onMessageEvent()")
    }

    @CallSuper
    override fun startLoading() {
        loading?.visibility = View.VISIBLE
        hideLoadErrorView()
    }

    @CallSuper
    override fun loadFinished() {
        loading?.visibility = View.GONE
    }

    @CallSuper
    override fun loadFailed(msg: String?) {
        loading?.visibility = View.GONE
    }

    fun onCreateView(view: View): View {
        logD(TAG, "BaseFragment-->onCreateView()")
        rootView = view
        loading = view.findViewById(R.id.loading)
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this)
        }
        return view
    }

    open fun loadDataOnce() {

    }

    protected fun showLoadErrorView(tip: String, block: View.() -> Unit) {
        if (loadErrorView != null) {
            loadErrorView?.visibility = View.VISIBLE
            return
        }
        if (rootView != null) {
            val viewStub = rootView?.findViewById<ViewStub>(R.id.loadErrorView)
            if (viewStub != null) {
                loadErrorView = viewStub.inflate()
                val loadErrorText = loadErrorView?.findViewById<TextView>(R.id.loadErrorText)
                loadErrorText?.text = tip
                val loadErrorkRootView = loadErrorView?.findViewById<View>(R.id.loadErrorkRootView)
                loadErrorkRootView?.setOnClickListener {
                    it?.block()
                }
            }
        }
    }

    protected fun hideLoadErrorView() {
        loadErrorView?.visibility = View.GONE
    }

    protected fun share(shareContent: String, shareType: Int) {
        ShareUtil.share(activity, shareContent, shareType)
    }

    protected fun showDialogShare(shareContent: String) {

    }
}