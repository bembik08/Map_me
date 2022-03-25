plugins {
    id("com.android.library")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    id("org.jetbrains.kotlin.android")
}

android {

    compileSdk = 31
    defaultConfig {

        minSdk = 27
        targetSdk = 31
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility (JavaVersion.VERSION_1_8)
        targetCompatibility (JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = Config.JVM_TARGET
    }
    buildToolsVersion = "31.0.0"

    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    //Modules
    implementation(project(Modules.MODULE_DOMAIN))

    // Kotlin
    implementation(Kotlin.CORE)
    implementation(Kotlin.STDLIB)

    // Design
    implementation(Design.APPCOMPAT)
    implementation(Design.MATERIAL)
    implementation(Design.CONSTRAINT_LAYOUT)
    implementation(Design.NAVIGATION_FRAGMENT)
    implementation(Design.NAVIGATION_UI_KTX)

    //ViewBinding
    implementation(ViewBindingDelegate.DELEGATE)

    // Retrofit
    implementation(Retrofit2.RETROFIT)
    implementation(Retrofit2.CONVERTER_JSON)
    implementation(Retrofit2.COROUTINES_ADAPTER)
    implementation(Retrofit2.LOGGING_INTERCEPTOR)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    //GoogleMap
    implementation(GoogleMaps.googleMap)

    //Koin
    implementation(Koin.CORE)
    implementation(Koin.ANDROID)
    implementation(Koin.ANDROID_COMPAT)

    //Tests
    testImplementation(Tests.JUNIT)
    androidTestImplementation(Tests.TEST_EXT_JUNIT)
    androidTestImplementation(Tests.ESPRESSO)
}