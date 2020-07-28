package com.example.eyedemo.logic.dao

object EyepetizerDatabase {

    private var mainPageDao: MainPageDao? = null

    private var videoDao: VideoDao? = null

    fun getMainPageDao(): MainPageDao {
        if (mainPageDao == null) {
            mainPageDao = MainPageDao()
        }
        return mainPageDao!!
    }

    fun getVideoDao(): VideoDao {
        if (videoDao == null) {
            videoDao = VideoDao()
        }
        return videoDao!!
    }
}