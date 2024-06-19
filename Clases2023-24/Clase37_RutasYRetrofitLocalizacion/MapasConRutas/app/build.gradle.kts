plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)



}

android {
    namespace = "com.example.mapas"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mapas"
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    




    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    //Mapas
    implementation(libs.play.services.maps)


    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    //Converter para JSON a nuestro modelo de datos.
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    // Acceso HTTP3. Simplifica la forma de trabajar con las peticiones HTTP.
    implementation("com.squareup.okhttp3:okhttp:4.9.1")
    // Login interceptor, que permiten mostrar en los logs del proyecto la información enviada y a recibir
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")
    implementation(libs.play.services.location)





    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}