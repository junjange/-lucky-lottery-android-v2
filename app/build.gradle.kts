import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.lang)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    id("com.google.gms.google-services")
}

fun getApiKey(propertyKey: String): String {
    return gradleLocalProperties(rootDir).getProperty(propertyKey)
}

android {
    namespace = "com.junjange.lotto3"
    compileSdk = Versions.COMPILE_SDK

    defaultConfig {
        applicationId = "com.junjange.lotto3"
        minSdk = Versions.MIN_SDK
        targetSdk = Versions.COMPILE_SDK
        versionCode = Versions.VERSION_CODE
        versionName = Versions.VERSION_NAME

        buildConfigField("String", "KAKAO_NATIVE_APP_KEY", getApiKey("KAKAO_NATIVE_APP_KEY"))
        resValue("string", "KAKAO_OAUTH_HOST", getApiKey("KAKAO_OAUTH_HOST"))

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        buildConfig = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(Modules.DOMAIN))
    implementation(project(Modules.PRESENTATION))
    implementation(project(Modules.DATA))
    implementation(project(Modules.KAKAO))
    implementation(project(Modules.FIREBASE))
    implementation(project(Modules.LOCAL))
    implementation(project(Modules.CORE_FEATURE))
    implementation(project(Modules.REMOTE))

    implementation(libs.bundles.android)
    implementation(libs.bundles.common)

    // ksp
    ksp(libs.ksp.hilt)

    // kakao
    implementation(libs.bundles.kakao)

    // google
    implementation(libs.bundles.google)

    // okhttp
    implementation(libs.okhttp.core)
    implementation(libs.okhttp.logging.interceptor)

    // test
    testImplementation(libs.junit)
    androidTestImplementation(libs.junit.ext)
    androidTestImplementation(libs.junit.espresso)
    debugImplementation(libs.compose.ui.test)
    debugImplementation(libs.compose.ui.tooling.debug)
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
}