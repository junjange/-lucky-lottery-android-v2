package com.junjange.remote.api


class ApiClient {

    object Credentials {
        private const val BASE = "/api/vi/credentials/"
        const val postCredentialsRegister = BASE + "register"
        const val postCredentialsRefresh = BASE + "refresh"
        const val postCredentialsLogin = BASE + "login"
        const val postCredentialsValidRegister = BASE + "oauth/valid/register"
    }

    object Lottery {
        private const val BASE = "/api/vi/lottery/"
        const val postLotterySave = BASE + "save"
        const val getLotteryRandom = BASE + "random"
        const val getLotteryGet = BASE + "get"
    }

    object PensionLottery {
        private const val BASE = "/api/vi/pension/lottery/"
        const val postPensionLotterySave = BASE + "save"
        const val getPensionLotteryRandom = BASE + "random"
    }

}