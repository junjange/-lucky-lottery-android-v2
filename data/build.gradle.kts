plugins {
    kotlin("jvm")
    alias(libs.plugins.ksp)
}

dependencies {
    implementation(project(Modules.DOMAIN))

    implementation(libs.coroutines.core)

    implementation(libs.hilt.core)

    // ksp
    ksp(libs.ksp.hilt)
}