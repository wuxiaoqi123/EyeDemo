package com.example.eyedemo.ui.notification.push

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.eyedemo.logic.MainPageRepository

@Suppress("UNCHECKED_CAST")
class PushViewModelFactory(private val repository: MainPageRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PushViewModel(repository) as T
    }
}