plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {

    compileSdk = 31
    defaultConfig {
        minSdk = 27
        targetSdk = 31
    }
    buildToolsVersion = "31.0.0"
}

dependencies {
    //Modules
    implementation(project(Modules.MODULE_DOMAIN))

    // Kotlin
    implementation(Kotlin.CORE)
    implementation(Kotlin.STDLIB)

    //GoogleMap
    implementation(GoogleMaps.googleMap)

    // Retrofit
    implementation(Retrofit2.RETROFIT)
    implementation(Retrofit2.CONVERTER_JSON)
    implementation(Retrofit2.COROUTINES_ADAPTER)
    implementation(Retrofit2.LOGGING_INTERCEPTOR)

    //Tests
    testImplementation(Tests.JUNIT)
    androidTestImplementation(Tests.TEST_EXT_JUNIT)
    androidTestImplementation(Tests.ESPRESSO)
}