plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.testeunitario_dummyapi"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.example.testeunitario_dummyapi"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = true
    }

    testOptions {
        unitTests {
            // Isso impede que chamadas do Android (como Log.e) quebrem os testes locais
            isReturnDefaultValues = true
        }
    }
}

dependencies {
    val lifecycle_version = "2.11.0"

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")

    //LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:${lifecycle_version}")

    //JUnit
    testImplementation("junit:junit:4.13.2")

    //Truth Google
    testImplementation("com.google.truth:truth:1.1.4")

    //Coroutine runTest
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")

    //Mockito
    testImplementation("org.mockito:mockito-core:5.7.0")

    //Core Testing (InstantTaskExecutorRule)
    testImplementation("androidx.arch.core:core-testing:2.2.0")

}