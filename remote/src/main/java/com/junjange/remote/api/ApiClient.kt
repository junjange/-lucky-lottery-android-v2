package com.junjange.remote.api


class ApiClient {

    object Credentials {
        private const val BASE = "/api/vi/credentials/"
        const val postCredentialsSignup2 = BASE + "signup2"
        const val postCredentialsRegister = BASE + "register"
        const val postCredentialsRefresh = BASE + "refresh"
        const val postCredentialsLogin = BASE + "login"
        const val postCredentialsLogin2 = BASE + "login2/{userId}"
        const val postCredentialsValidRegister = BASE + "oauth/valid/register"
    }

    object Lottery {
        private const val BASE = "/api/vi/lottery/"
        const val postLotterySave = BASE + "save"
        const val getLotteryRandom = BASE + "random"
        const val getLotteryGet = BASE + "get"
    }

}