package com.junjange.remote.api


class ApiClient {

    object CREDENTIALS {
        private const val BASE = "/api/vi/credentials/"
        const val postCredentialsSignup2 = BASE + "signup2"
        const val postCredentialsRegister = BASE + "register"
        const val postCredentialsRefresh = BASE + "refresh"
        const val postCredentialsLogin = BASE + "login"
        const val postCredentialsLogin2 = BASE + "login2/{userId}"
        const val postCredentialsValidRegister = BASE + "oauth/valid/register"
    }

}