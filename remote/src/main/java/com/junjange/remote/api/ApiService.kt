package com.junjange.remote.api

import com.junjange.remote.model.BaseResponse
import com.junjange.remote.model.request.LotteryRandomRequest
import com.junjange.remote.model.request.NotificationRegisterRequest
import com.junjange.remote.model.request.NotificationRequest
import com.junjange.remote.model.request.PensionLotteryRandomRequest
import com.junjange.remote.model.request.RefreshRequest
import com.junjange.remote.model.request.RegisterRequest
import com.junjange.remote.model.request.UserMyInfoRequest
import com.junjange.remote.model.response.ImagesUploadResponse
import com.junjange.remote.model.response.IsRegisteredResponse
import com.junjange.remote.model.response.JwtTokenResponse
import com.junjange.remote.model.response.LotteryGetResponse
import com.junjange.remote.model.response.LotteryNumbersResponse
import com.junjange.remote.model.response.LotteryRandomNumbersResponse
import com.junjange.remote.model.response.PensionLotteryGetResponse
import com.junjange.remote.model.response.PensionLotteryHomeResponse
import com.junjange.remote.model.response.PensionLotteryRandomResponse
import com.junjange.remote.model.response.UserMyInfoResponse
import okhttp3.MultipartBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

internal interface ApiService {
    @POST(ApiClient.Credentials.POST_CREDENTIALS_REGISTER)
    suspend fun postRegister(
        @Query("idToken") idToken: String,
        @Query("provider") provider: String,
        @Body body: RegisterRequest,
    ): BaseResponse<JwtTokenResponse>

    @POST(ApiClient.Credentials.POST_CREDENTIALS_REFRESH)
    suspend fun postRefresh(
        @Body body: RefreshRequest,
    ): BaseResponse<JwtTokenResponse>

    @POST(ApiClient.Credentials.POST_CREDENTIALS_LOGIN)
    suspend fun postLogin(
        @Query("idToken") idToken: String,
        @Query("provider") provider: String,
    ): BaseResponse<JwtTokenResponse>

    @POST(ApiClient.Credentials.POST_CREDENTIALS_LOGOUT)
    suspend fun postLogout(): BaseResponse<Unit>

    @GET(ApiClient.Credentials.GET_CREDENTIALS_VALID_REGISTER)
    suspend fun getValidRegister(
        @Query("idToken") idToken: String,
        @Query("provider") provider: String,
    ): BaseResponse<IsRegisteredResponse>

    @PATCH(ApiClient.User.PATCH_LOTTERY_NOTIFICATION)
    suspend fun patchLotteryNotification(
        @Body body: NotificationRequest,
    ): BaseResponse<Unit>

    @PATCH(ApiClient.User.PATCH_PENSION_LOTTERY_NOTIFICATION)
    suspend fun patchPensionLotteryNotification(
        @Body body: NotificationRequest,
    ): BaseResponse<Unit>

    @GET(ApiClient.User.GET_USER_MY_INFO)
    suspend fun getUserMyIn(): BaseResponse<UserMyInfoResponse>

    @PATCH(ApiClient.User.PATCH_USER_MY_INFO)
    suspend fun patchUserMyInfo(
        @Body body: UserMyInfoRequest,
    ): BaseResponse<Unit>

    @POST(ApiClient.Lottery.POST_LOTTERY_SAVE)
    suspend fun postLotterySave(
        @Body body: LotteryRandomRequest,
    ): BaseResponse<Unit>

    @GET(ApiClient.Lottery.GET_LOTTERY_RANDOM)
    suspend fun getLotteryRandom(): BaseResponse<LotteryRandomNumbersResponse>

    @GET(ApiClient.Lottery.GET_LOTTERY_GET)
    suspend fun getLotteryGet(
        @Query("page") page: Int,
        @Query("size") size: Int,
    ): BaseResponse<LotteryGetResponse>

    @POST(ApiClient.PensionLottery.POST_PENSION_LOTTERY_SAVE)
    suspend fun postPensionLotterySave(
        @Body body: PensionLotteryRandomRequest,
    ): BaseResponse<Unit>

    @GET(ApiClient.PensionLottery.GET_PENSION_LOTTERY_RANDOM)
    suspend fun getPensionLotteryRandom(): BaseResponse<PensionLotteryRandomResponse>

    @GET(ApiClient.PensionLottery.GET_PENSION_LOTTERY_GET)
    suspend fun getPensionLotteryGet(
        @Query("page") page: Int,
        @Query("size") size: Int,
    ): BaseResponse<PensionLotteryGetResponse>

    @GET(ApiClient.Winning.GET_WINNING_LOTTERY_HOME)
    suspend fun getLotteryHome(): BaseResponse<LotteryNumbersResponse>

    @GET(ApiClient.Winning.GET_WINNING_PENSION_LOTTERY_HOME)
    suspend fun getPensionLotteryHome(): BaseResponse<PensionLotteryHomeResponse>

    @GET(ApiClient.Notification.POST_NOTIFICATION_REGISTER_TOKEN)
    suspend fun postNotificationRegisterToken(
        @Body body: NotificationRegisterRequest,
    ): BaseResponse<Unit>

    @Multipart
    @POST(ApiClient.Images.POST_IMAGES_UPLOAD)
    suspend fun postImagesUpload(
        @Part file: MultipartBody.Part,
    ): BaseResponse<ImagesUploadResponse>
}
