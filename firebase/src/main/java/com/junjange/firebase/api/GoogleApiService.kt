package com.junjange.firebase.api

import com.junjange.firebase.model.request.GoogleOauthTokenRequest
import com.junjange.firebase.model.response.GoogleOauthTokenResponse
import retrofit2.http.Body
import retrofit2.http.POST

internal interface GoogleApiService {
    @POST(GoogleApiClient.OAUTH2.POST_OAUTH2_TOKEN)
    suspend fun postOauthToken(
        @Body body: GoogleOauthTokenRequest,
    ): GoogleOauthTokenResponse
}
