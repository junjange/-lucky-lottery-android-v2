package com.junjange.remote.api


class ApiClient {

    object Credentials {
        private const val BASE = "/api/v1/credentials/"
        const val postCredentialsRegister = BASE + "register"
        const val postCredentialsRefresh = BASE + "refresh"
        const val postCredentialsLogin = BASE + "login"
        const val getCredentialsValidRegister = BASE + "oauth/valid/register"
    }

    object Lottery {
        private const val BASE = "/api/v1/lottery/"
        const val postLotterySave = BASE + "save"
        const val getLotteryRandom = BASE + "random"
        const val getLotteryGet = BASE + "get"
    }

    object PensionLottery {
        private const val BASE = "/api/v1/pension/lottery/"
        const val postPensionLotterySave = BASE + "save"
        const val getPensionLotteryRandom = BASE + "random"
    }

}