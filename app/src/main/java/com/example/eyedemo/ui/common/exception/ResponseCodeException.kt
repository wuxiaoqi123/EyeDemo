package com.example.eyedemo.ui.common.exception

class ResponseCodeException(val responseCode: Int) :
    RuntimeException("Http request failed with response code $responseCode")