plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(Versions.COMPILE_SDK_VERSION)
    buildToolsVersion = Versions.BUILD_TOOL_VERSION

    defaultConfig {
        applicationId = "com.enigmacamp.myfulldaggerapp"
        minSdkVersion(Versions.MIN_SDK_VERSION)
        targetSdkVersion(Versions.TARGET_SDK_VERSION)
        versionCode(Versions.VERSION_CODE)
        versionName = Versions.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Versions.JVM_TARGET
    }
}

dependencies {
    implementation(project(":customerFeature"))
    implementation(project(":core"))
    implementation(project(":authenticationFeature"))
    implementation(project(":customerFeature"))

    dagger()
    daggerAndroid()
    room()
    retrofit()
    coroutine()
    lifecycle()
    core()
    ui()

    unitTest()
    androidUnitTest()
}