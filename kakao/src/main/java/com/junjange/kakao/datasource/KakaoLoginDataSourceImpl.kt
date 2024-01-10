package com.junjange.kakao.datasource

import android.content.Context
import com.junjange.data.datasource.KakaoLoginDataSource
import com.junjange.data.model.KakaoAccessTokenResponse
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

internal class KakaoLoginDataSourceImpl @Inject constructor(
    @ApplicationContext private val context: Context,
) : KakaoLoginDataSource {

    /**
     * @param context: Activity context
     */
    override suspend fun login(): Result<KakaoAccessTokenResponse> = runCatching {
        suspendCancellableCoroutine { continuation ->
            val callback: (OAuthToken?, Throwable?) -> Unit = { token, throwable ->
                when {
                    throwable != null -> continuation.resumeWithException(throwable)
                    token != null && continuation.isActive -> {
                        val accessToken = KakaoAccessTokenResponse(
                            accessToken = token.accessToken,
                            id_token = token.idToken!!
                        )
                        continuation.resume(accessToken)
                    }
                }
            }

            val userApiClient = UserApiClient.instance
            if (userApiClient.isKakaoTalkLoginAvailable(context)) {
                userApiClient.loginWithKakaoTalk(context, callback = callback)
            } else {
                userApiClient.loginWithKakaoAccount(context, callback = callback)
            }
        }
    }
}