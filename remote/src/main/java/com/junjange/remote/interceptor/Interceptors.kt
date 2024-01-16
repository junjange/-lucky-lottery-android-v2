package com.junjange.remote.interceptor

import okhttp3.Interceptor

data class Interceptors(
    val interceptors: List<Interceptor>,
) {

    companion object {
        val Empty = Interceptors(emptyList())
    }
}
