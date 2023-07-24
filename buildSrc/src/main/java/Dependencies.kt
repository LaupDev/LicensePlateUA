object Dependencies {

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleKtx}"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"

        const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
        const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
        const val composeUiTooling = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
        const val composeMaterial3 = "androidx.compose.material3:material3:${Versions.material}"

        object Room {
            const val runtime = "androidx.room:room-runtime:${Versions.room}"
            const val compiler = "androidx.room:room-compiler:${Versions.room}"
            const val ktx = "androidx.room:room-ktx:${Versions.room}"
        }
    }

    object Google {
        const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
        const val hiltCompose = "androidx.hilt:hilt-navigation-compose:${Versions.hiltCompose}"
        const val hiltComposeCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltCompose}"
    }

    object Kotlin {
        const val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"
    }

    object Other {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val retrofitMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofitMoshi}"

        const val picasso = "com.squareup.picasso:picasso:${Versions.picasso}"

        const val composeNavigation = "io.github.raamcosta.compose-destinations:core:${Versions.composeNavigation}"
        const val composeNavigationKsp = "io.github.raamcosta.compose-destinations:ksp:${Versions.composeNavigation}"

        const val metadata = "org.jetbrains.kotlinx:kotlinx-metadata-jvm:${Versions.metadata}"
    }

    object Testing {
        const val jUnit = "junit:junit:${Versions.junit}"
        const val jUnitAssertions = "androidx.test.ext:junit:${Versions.junitAssertions}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
        const val jUnitCompose = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"

        const val room = "androidx.room:room-testing:${Versions.room}"
    }

    object Debug {
        const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
        const val composeUiManifest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"
    }
}