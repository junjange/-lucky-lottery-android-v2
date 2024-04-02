package com.junjange.presentation.ui.my

sealed class MyEffect {
    class NavigateToEditProfile(
        val nickname: String,
        val profilePath: String?,
    ) : MyEffect()

    data object NavigateToUsageTerm : MyEffect()

    data object NavigateToSplash : MyEffect()

    class NavigateToWithdrawal(val oauthProvider: OauthProvider) : MyEffect()

    class NavigateToNotification(
        val lottoNotificationState: Boolean,
        val pensionLottoNotificationState: Boolean,
    ) : MyEffect()
}

enum class OauthProvider(val displayName: String) {
    KAKAO("Kakao 로그인"),
    GOOGLE("Google 로그인"),
    ;

    companion object {
        fun from(value: String): OauthProvider {
            return OauthProvider.entries.find { it.name == value } ?: KAKAO
        }
    }
}
