package com.example.eyedemo.util

import android.app.Activity
import java.lang.ref.WeakReference
import java.util.*

object ActivityCollector {

    private val activitys = Stack<WeakReference<Activity>>()

    fun pushTask(task: WeakReference<Activity>?) {
        activitys.push(task)
    }

    fun removeTask(task: WeakReference<Activity>?) {
        activitys.remove(task)
    }

    fun removeTask(taskIndex: Int) {
        if (activitys.size > taskIndex) {
            activitys.removeAt(taskIndex)
        }
    }

    fun removeTop() {
        val end = activitys.size
        val start = 1
        for (i in end - 1 downTo start) {
            val mActivity = activitys[i].get()
            if (mActivity != null && !mActivity.isFinishing) {
                mActivity.finish()
            }
        }
    }

    fun removeAll() {
        for (task in activitys) {
            val mActivity = task.get()
            if (mActivity != null && !mActivity.isFinishing) {
                mActivity.finish()
            }
        }
    }
}