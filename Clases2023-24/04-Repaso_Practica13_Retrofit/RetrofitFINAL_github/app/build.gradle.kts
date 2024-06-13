plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.example.retrofitfinal"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.retrofitfinal"
        minSdk = 30
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

}

dependencies {

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    //JSON Goolgle
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")



    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}