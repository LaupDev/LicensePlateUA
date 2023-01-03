plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
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

    implementation (Dependencies.AndroidX.coreKtx)
    implementation (Dependencies.AndroidX.lifecycleKtx)
    implementation (Dependencies.AndroidX.activityCompose)
    implementation (Dependencies.AndroidX.composeUi)
    implementation (Dependencies.AndroidX.composeUiTooling)
    implementation (Dependencies.AndroidX.composeMaterial3)



    testImplementation (Dependencies.Testing.jUnit)
    androidTestImplementation (Dependencies.Testing.jUnitAssertions)
    androidTestImplementation (Dependencies.Testing.espresso)
    androidTestImplementation (Dependencies.Testing.jUnitCompose)

    debugImplementation (Dependencies.Debug.composeUiTooling)
    debugImplementation (Dependencies.Debug.composeUiManifest)
}