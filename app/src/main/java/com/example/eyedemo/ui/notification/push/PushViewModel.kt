package com.example.eyedemo.ui.notification.push

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.eyedemo.logic.MainPageRepository
import com.example.eyedemo.logic.model.PushMessage
import com.example.eyedemo.logic.network.api.MainPageService

class PushViewModel(val repository: MainPageRepository) : ViewModel() {

    var dataList = ArrayList<PushMessage.Message>()

    private var requestParamLiveData = MutableLiveData<String>()

    var nextPageUrl: String? = null

    val dataListLiveData = Transformations.switchMap(requestParamLiveData) { url ->
        liveData {
            val result = try {
                val pushMessage = repository.refreshPushMessage(url)
                Result.success(pushMessage)
            } catch (e: Exception) {
                Result.failure<PushMessage>(e)
            }
            emit(result)
        }
    }

    fun onRefresh() {
        requestParamLiveData.value = MainPageService.PUSHMESSAGE_URL
    }

    fun onLoadMore() {
        requestParamLiveData.value = nextPageUrl ?: ""
    }
}