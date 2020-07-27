package com.example.eyedemo.logic.network.api

import com.example.eyedemo.logic.model.VideoBeanForClient
import com.example.eyedemo.logic.model.VideoRelated
import com.example.eyedemo.logic.model.VideoReplies
import com.example.eyedemo.logic.network.ServiceCreator
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url


interface VideoService {

    companion object {
        const val VIDEO_REPLIES_URL = "${ServiceCreator.BASE_URL}api/v2/replies/video?videoId="
    }

    @GET("api/v2/video/{id}")
    fun getVideoBeanForClient(@Path("id") videoId: Long): Call<VideoBeanForClient>

    @GET("api/v4/video/related")
    fun getVideoRelated(@Query("id") videoId: Long): Call<VideoRelated>

    @GET
    fun getVideoReplies(@Url url: String): Call<VideoReplies>
}