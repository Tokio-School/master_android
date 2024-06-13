plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.retrofit"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.retrofit"
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

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    //Converter para JSON a nuestro modelo de datos.
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    // Acceso HTTP3. Simplifica la forma de trabajar con las peticiones HTTP.
    implementation("com.squareup.okhttp3:okhttp:4.9.1")
    // Login interceptor, que permiten mostrar en los logs del proyecto la información enviada y a recibir
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")



    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}