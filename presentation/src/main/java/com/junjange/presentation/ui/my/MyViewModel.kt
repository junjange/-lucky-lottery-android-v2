package com.junjange.presentation.ui.my

import com.junjange.domain.usecase.DeleteLocalDataUseCase
import com.junjange.domain.usecase.GetUserMyInfoUseCase
import com.junjange.domain.usecase.PostLogoutUseCase
import com.junjange.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MyViewModel
    @Inject
    constructor(
        private val getUserMyInfoUseCase: GetUserMyInfoUseCase,
        private val postLogoutUseCase: PostLogoutUseCase,
        private val deleteLocalDataUseCase: DeleteLocalDataUseCase,
    ) : BaseViewModel() {
        private val _uiState = MutableStateFlow(MyState())
        val uiState: StateFlow<MyState> = _uiState.asStateFlow()

        private val _effect = MutableSharedFlow<MyEffect>()
        val effect: SharedFlow<MyEffect> = _effect.asSharedFlow()

        init {
            getUserMyInfo()
        }

        fun getUserMyInfo() {
            launch {
                getUserMyInfoUseCase().onSuccess { userMyInfo ->
                    _uiState.update {
                        it.copy(
                            nickname = userMyInfo.nickname,
                            profilePath = userMyInfo.profilePath,
                            oauthProvider = OauthProvider.from(userMyInfo.oauthProvider),
                            lotteryNotificationStatus = userMyInfo.lotteryNotificationStatus,
                            pensionLotteryNotificationStatus = userMyInfo.pensionLotteryNotificationStatus,
                        )
                    }
                }.onFailure {
                    // TODO 예외 처리
                }
            }
        }

        fun onClickedNotification() {
            launch {
                _effect.emit(
                    MyEffect.NavigateToNotification(
                        lottoNotificationState = uiState.value.lotteryNotificationStatus,
                        pensionLottoNotificationState = uiState.value.pensionLotteryNotificationStatus,
                    ),
                )
            }
        }

        fun onClickedEditProfile() {
            launch {
                _effect.emit(
                    MyEffect.NavigateToEditProfile(
                        nickname = uiState.value.nickname,
                        profilePath = uiState.value.profilePath,
                    ),
                )
            }
        }

        fun onClickedUsageTerm() {
            launch {
                _effect.emit(MyEffect.NavigateToUsageTerm)
            }
        }

        fun onClickedSignOut() {
            launch {
                postLogoutUseCase().onSuccess {
                    deleteLocalData()
                }.onFailure {
                    // TODO 예외 처리
                }
            }
        }

        private fun deleteLocalData() {
            launch {
                deleteLocalDataUseCase().onSuccess {
                    _effect.emit(MyEffect.NavigateToSplash)
                }.onFailure {
                    // TODO 예외 처리
                }
            }
        }

        fun onClickedWithdrawal() {
            launch {
                _effect.emit(MyEffect.NavigateToWithdrawal(uiState.value.oauthProvider))
            }
        }
    }
