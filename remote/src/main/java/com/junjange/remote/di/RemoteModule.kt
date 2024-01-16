package com.junjange.remote.di

import com.junjange.data.provider.AccessTokenProvider
import com.junjange.data.provider.RefreshTokenProvider
import com.junjange.remote.interceptor.AccessTokenInterceptor
import com.junjange.remote.api.ApiService
import com.junjange.remote.api.AuthenticationListener
import com.junjange.remote.api.Authenticator
import com.junjange.remote.interceptor.Interceptors
import com.junjange.remote.api.RefreshApiService
import com.junjange.remote.api.baseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.junjange.remote.api.BaseUrl
import com.junjange.remote.interceptor.ErrorResponseInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RemoteModule {

    @Provides
    @Singleton
    fun provideApiService(
        baseUrl: BaseUrl,
        interceptors: Interceptors,
        accessTokenProvider: AccessTokenProvider,
        refreshTokenProvider: RefreshTokenProvider,
        authenticationListener: AuthenticationListener,
    ): ApiService {

        val authenticator = Authenticator(
            apiService = provideRefreshApiService(baseUrl, interceptors),
            accessTokenProvider = accessTokenProvider,
            refreshTokenProvider = refreshTokenProvider,
            authenticationListener = authenticationListener
        )

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(
                createOkHttpClient(interceptors) {
                    addInterceptor(AccessTokenInterceptor(accessTokenProvider))
                    authenticator(authenticator)
                    addInterceptor(ErrorResponseInterceptor())
                }
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    private fun provideRefreshApiService(
        baseUrl: BaseUrl,
        interceptors: Interceptors,
    ): RefreshApiService = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(createOkHttpClient(interceptors))
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RefreshApiService::class.java)

    private fun createOkHttpClient(
        interceptors: Interceptors,
        apply: OkHttpClient.Builder.() -> Unit = { },
    ) = OkHttpClient.Builder()
        .apply {
            interceptors.interceptors.forEach(::addInterceptor)
        }
        .apply(apply)
        .build()
}
