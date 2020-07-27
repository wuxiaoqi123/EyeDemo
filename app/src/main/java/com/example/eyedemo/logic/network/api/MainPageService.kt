package com.example.eyedemo.logic.network.api

import com.example.eyedemo.logic.model.*
import com.example.eyedemo.logic.network.ServiceCreator
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface MainPageService {

    companion object {
        const val DISCOVERY_URL = "${ServiceCreator.BASE_URL}api/v7/index/tab/discovery"

        const val HOMEPAGE_RECOMMEND_URL =
            "${ServiceCreator.BASE_URL}api/v5/index/tab/allRec?page=0"

        const val DAILY_URL = "${ServiceCreator.BASE_URL}api/v5/index/tab/feed"

        const val COMMUNITY_RECOMMEND_URL = "${ServiceCreator.BASE_URL}api/v7/community/tab/rec"

        const val FOLLOW_URL = "${ServiceCreator.BASE_URL}api/v6/community/tab/follow"

        const val PUSHMESSAGE_URL = "${ServiceCreator.BASE_URL}api/v3/messages"
    }

    @GET
    fun getDiscovery(@Url url: String): Call<Discovery>

    @GET
    fun getHomePageRecommend(@Url url: String): Call<HomePageRecommend>

    @GET
    fun getDaily(@Url url: String): Call<Daily>

    @GET
    fun getCommunityRecommend(@Url url: String): Call<CommunityRecommend>

    @GET
    fun getFollow(@Url url: String): Call<Follow>

    @GET
    fun getPushMessage(@Url url: String): Call<PushMessage>

    @GET("api/v3/queries/hot")
    fun getHotSearch(): Call<List<String>>
}