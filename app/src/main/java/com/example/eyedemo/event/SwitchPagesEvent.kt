package com.example.eyedemo.event

open class SwitchPagesEvent(var activityClass: Class<*>? = null) : MessageEvent()