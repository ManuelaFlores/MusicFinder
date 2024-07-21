object Versions {
    const val kotlin = "1.9.10"
    const val koin = "2.2.2"
    const val android_core = "1.3.2"
    const val app_compat = "1.2.0"
    const val constraint_layout = "2.0.4"
    const val mokk= "1.10.5"
    const val junit = "4.13.2"
    const val junit_androidx = "1.1.2"
    const val espresso_androidx = "3.3.0"
    const val material_design = "1.4.0-alpha01"
    const val retrofit = "2.9.0"
    const val okhttp3 = "4.7.2"
    const val okhttp3_interceptor = "4.7.2"
    const val moshi = "2.9.0"
    const val coroutines_core = "1.4.1"
    const val coroutines_android = "1.3.9"
    const val lifecycle_extensions = "1.1.1"
    const val lifecycle_viewmodel = "2.3.0"
    const val lifecycle_runtime = "2.3.0"
    const val fragment = "1.3.1"
    const val firebase_analytics = "18.0.2"
    const val firebase_core = "18.0.2"
    const val firebase_database = "19.6.0"
    const val coil_version = "1.2.1"
    const val exoPlayer = "2.14.0"
}

object Dependencies {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    val koin_android = "org.koin:koin-android:${Versions.koin}"
    val koin_scope = "org.koin:koin-androidx-scope:${Versions.koin}"
    val koin_viewmodel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    val koin_fragment = "org.koin:koin-androidx-fragment:${Versions.koin}"
    val android_core = "androidx.core:core-ktx:${Versions.android_core}"
    val app_compat = "androidx.appcompat:appcompat:${Versions.app_compat}"
    val constraint_layout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    val mokk = "io.mockk:mockk:${Versions.mokk}"
    val coroutines_test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines_core}"
    val junit = "junit:junit:${Versions.junit}"
    val junit_androidx = "androidx.test.ext:junit:${Versions.junit_androidx}"
    val espresso_androidx = "androidx.test.espresso:espresso-core:${Versions.espresso_androidx}"
    val material_design = "com.google.android.material:material:${Versions.material_design}"

    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val okhttp3 = "com.squareup.okhttp3:okhttp:${Versions.okhttp3}"
    val okhttp3_interceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3_interceptor}"
    val moshi = "com.squareup.retrofit2:converter-moshi:${Versions.moshi}"

    val coroutines_core =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines_core}"
    val coroutines_android =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines_android}"

    val lifecycle_extensions = "android.arch.lifecycle:extensions:${Versions.lifecycle_extensions}"
    val lifecycle_viewmodel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_viewmodel}"
    val lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle_runtime}"

    val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"

    val firebase_analytics = "com.google.firebase:firebase-analytics:${Versions.firebase_analytics}"
    val firebase_core = "com.google.firebase:firebase-core:${Versions.firebase_core}"
    val firebase_database =
        "com.google.firebase:firebase-database-ktx:${Versions.firebase_database}"

    val coil = "io.coil-kt:coil:${Versions.coil_version}"
    val exoPlayer = "com.google.android.exoplayer:exoplayer:${Versions.exoPlayer}"

}

object Config {
    val compileSdk = 30
    val minSdk = 24
    val targetSdk = 30
    val javaVersion = 1.8
}