plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

android {

    compileSdk = 31
    defaultConfig {
        applicationId = "com.teck.map_me"
        minSdk = 27
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
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

    buildFeatures {
        viewBinding = true
    }
    buildToolsVersion = "31.0.0"
}

dependencies {
    /** Modules **/
    implementation(project(Modules.MODULE_DATA))
    implementation(project(Modules.MODULE_DOMAIN))
    implementation(project(Modules.MODULE_UI))

    /** Koin **/
    implementation(Koin.CORE)
    implementation(Koin.ANDROID)
    implementation(Koin.ANDROID_COMPAT)

    /**ViewBinding Delegate**/
    implementation(ViewBindingDelegate.DELEGATE)

    /**Google Map**/
    implementation(GoogleMaps.googleMap)

    /**Room**/
    kapt(Room.COMPILER)
    implementation(Room.RUN_TIME)
    implementation(Room.KTX)

    implementation(Kotlin.CORE)
    implementation(Design.APPCOMPAT)
    implementation(Design.MATERIAL)
    implementation(Design.CONSTRAINT_LAYOUT)
    implementation(Design.NAVIGATION_FRAGMENT)
    implementation(Design.NAVIGATION_UI_KTX)
    testImplementation(Tests.JUNIT)
    androidTestImplementation(Tests.TEST_EXT_JUNIT)
    androidTestImplementation(Tests.ESPRESSO)
}
secrets {
    defaultPropertiesFileName = "local.properties.defaults"
}