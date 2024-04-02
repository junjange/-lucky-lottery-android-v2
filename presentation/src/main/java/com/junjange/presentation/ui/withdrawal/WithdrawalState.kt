package com.junjange.presentation.ui.withdrawal

data class WithdrawalState(
    val step: Int = 1,
    val isWithdrawalDialogShowing: Boolean = false,
    val oauthProvider: OauthProvider = OauthProvider.GOOGLE,
)

enum class OauthProvider {
    KAKAO,
    GOOGLE,
    ;

    companion object {
        fun from(value: String): OauthProvider {
            return OauthProvider.entries.find { it.name == value } ?: KAKAO
        }
    }
}
