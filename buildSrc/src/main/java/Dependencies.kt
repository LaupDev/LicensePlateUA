object Dependencies {

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleKtx}"
        const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
        const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
        const val composeUiTooling = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
        const val composeMaterial3 = "androidx.compose.material3:material3:${Versions.material}"
    }

    object Testing {
        const val jUnit = "junit:junit:${Versions.junit}"
        const val jUnitAssertions = "androidx.test.ext:junit:${Versions.junitAssertions}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
        const val jUnitCompose = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    }

    object Debug {
        const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
        const val composeUiManifest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"
    }
}