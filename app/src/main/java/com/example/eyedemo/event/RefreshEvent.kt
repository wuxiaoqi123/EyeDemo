package com.example.eyedemo.event

open class RefreshEvent(var activityClass: Class<*>? = null) : MessageEvent()