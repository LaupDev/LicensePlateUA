plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = ConfigData.namespace
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = ConfigData.applicationId
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner =  "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.kotlinCompilerExtension
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    implementation (Dependencies.AndroidX.activityCompose)
    implementation (Dependencies.AndroidX.composeUi)
    implementation (Dependencies.AndroidX.composeUiTooling)
    implementation (Dependencies.AndroidX.composeMaterial3)

    //Ktx
    implementation (Dependencies.AndroidX.coreKtx)
    implementation (Dependencies.AndroidX.lifecycleKtx)
    implementation (Dependencies.AndroidX.fragmentKtx)

    //Kotlin Coroutines
    implementation (Dependencies.Kotlin.kotlinCoroutines)

    //Room
    implementation (Dependencies.AndroidX.Room.runtime)
    implementation (Dependencies.AndroidX.Room.ktx)
    annotationProcessor (Dependencies.AndroidX.Room.compiler)
    ksp (Dependencies.AndroidX.Room.compiler)

    //Retrofit
    implementation (Dependencies.Other.retrofit)
    implementation (Dependencies.Other.retrofitMoshi)

    //Coil
    implementation (Dependencies.Other.coil)
    implementation (Dependencies.Other.coilCompose)

    //Hilt
    implementation (Dependencies.Google.hilt)
    implementation (Dependencies.Google.hiltCompose)
    ksp (Dependencies.Google.hiltCompiler)
    ksp (Dependencies.Google.hiltComposeCompiler)

    //Timber
    implementation (Dependencies.Other.timber)

    //Navigation
    implementation (Dependencies.Other.composeNavigation)
    ksp (Dependencies.Other.composeNavigationKsp)

    ksp (Dependencies.Other.metadata)

    testImplementation (Dependencies.Testing.jUnit)
    testImplementation (Dependencies.Testing.room)
    androidTestImplementation (Dependencies.Testing.jUnitAssertions)
    androidTestImplementation (Dependencies.Testing.espresso)
    androidTestImplementation (Dependencies.Testing.jUnitCompose)

    debugImplementation (Dependencies.Debug.composeUiTooling)
    debugImplementation (Dependencies.Debug.composeUiManifest)
}