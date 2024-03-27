package com.junjange.presentation.ui.login

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.junjange.domain.usecase.GetFCMTokenUseCase
import com.junjange.domain.usecase.GetValidRegisterUseCase
import com.junjange.domain.usecase.KakaoLoginUseCase
import com.junjange.domain.usecase.PostLoginUseCase
import com.junjange.domain.usecase.PostNotificationRegisterTokenUseCase
import com.junjange.domain.usecase.SaveJwtTokenUseCase
import com.junjange.presentation.base.BaseViewModel
import com.junjange.presentation.ui.login.LoginEffect.NavigateToMain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel
    @Inject
    constructor(
        private val kakaoLoginUseCase: KakaoLoginUseCase,
        private val getValidRegisterUseCase: GetValidRegisterUseCase,
        private val postLoginUseCase: PostLoginUseCase,
        private val saveJwtTokenUseCase: SaveJwtTokenUseCase,
        private val postNotificationRegisterTokenUseCase: PostNotificationRegisterTokenUseCase,
        private val getFCMTokenUseCase: GetFCMTokenUseCase,
    ) : BaseViewModel() {
        private val _uiState = MutableStateFlow(LoginState())
        val uiState: StateFlow<LoginState> = _uiState.asStateFlow()

        private val _effect = MutableSharedFlow<LoginEffect>()
        val effect: SharedFlow<LoginEffect> = _effect.asSharedFlow()

        fun kakaoLogin(deviceId: String) {
            launch {
                kakaoLoginUseCase().onSuccess {
                    it.idToken?.let { idToken ->
                        getValidRegisterUseCase(
                            idToken = idToken,
                            provider = KAKAO,
                        ).onSuccess { isRegistered ->
                            if (isRegistered.isRegistered) {
                                postLogin(
                                    idToken = idToken,
                                    provider = KAKAO,
                                    deviceId = deviceId,
                                )
                            } else {
                                _effect.emit(
                                    LoginEffect.NavigateToRegister(
                                        idToken = idToken,
                                        provider = KAKAO,
                                    ),
                                )
                            }
                        }.onFailure {
                            // TODO 예외 처리
                        }
                    }
                }.onFailure {
                    // TODO 예외 처리
                }
            }
        }

        fun googleLogin(
            result: Task<GoogleSignInAccount>?,
            deviceId: String,
        ) {
            try {
                val account = result?.getResult(ApiException::class.java)
                account?.let {
                    account.idToken?.let { idToken ->
                        launch {
                            getValidRegisterUseCase(
                                idToken = idToken,
                                provider = GOOGLE,
                            ).onSuccess { isRegistered ->
                                if (isRegistered.isRegistered) {
                                    postLogin(
                                        idToken = idToken,
                                        provider = GOOGLE,
                                        deviceId = deviceId,
                                    )
                                } else {
                                    _effect.emit(
                                        LoginEffect.NavigateToRegister(
                                            idToken = idToken,
                                            provider = GOOGLE,
                                        ),
                                    )
                                }
                            }.onFailure {
                                // TODO 예외 처리
                            }
                        }
                    } ?: run {
                        // TODO 예외 처리
                    }
                } ?: run {
                    // TODO 예외 처리
                }
            } catch (e: ApiException) {
                // TODO network error
            }
        }

        private fun postLogin(
            idToken: String,
            provider: String,
            deviceId: String,
        ) {
            launch {
                postLoginUseCase(idToken = idToken, provider = provider)
                    .onSuccess {
                        saveJwtTokenUseCase(jwtToken = it)
                            .onSuccess {
                                getFCMToken(deviceId = deviceId)
                            }.onFailure {
                                // TODO 예외 처리
                            }
                    }.onFailure {
                        // TODO 예외 처리
                    }
            }
        }

        private fun getFCMToken(deviceId: String) {
            launch {
                getFCMTokenUseCase().onSuccess { fcmToken ->
                    postNotificationRegisterTokenUseCase(
                        deviceId = deviceId,
                        fcmToken = fcmToken,
                    ).onSuccess {
                        _effect.emit(NavigateToMain)
                    }.onFailure {
                        // TODO 예외 처리
                    }
                }.onFailure {
                    // TODO 예외 처리
                }
            }
        }

        companion object {
            const val KAKAO = "KAKAO"
            const val GOOGLE = "GOOGLE"
        }
    }
