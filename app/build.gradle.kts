plugins {
    alias(libs.plugins.android.application) // Usando el alias para el plugin de Android
}

android {
    namespace = "com.example.coffeeexpressandroid"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.coffeeexpressandroid"
        minSdk = 24
        targetSdk = 35
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
}

dependencies {
    implementation(libs.appcompat)              // Usando el alias para appcompat
    implementation(libs.material)               // Usando el alias para material
    implementation(libs.constraintlayout)       // Usando el alias para constraintlayout
    implementation(libs.lifecycle.livedata.ktx) // Usando el alias para lifecycle-livedata-ktx
    implementation(libs.lifecycle.viewmodel.ktx) // Usando el alias para lifecycle-viewmodel-ktx
    implementation(libs.navigation.fragment)    // Usando el alias para navigation-fragment
    implementation(libs.navigation.ui)          // Usando el alias para navigation-ui
    implementation(libs.retrofit)               // Usando el alias para retrofit
    implementation(libs.gson)                   // Usando el alias para gson
    implementation(libs.glide)                  // Usando el alias para glide
    annotationProcessor(libs.glide.compiler)    // Usando el alias para glide-compiler
    testImplementation(libs.junit)              // Usando el alias para junit
    androidTestImplementation(libs.ext.junit)   // Usando el alias para ext-junit
    androidTestImplementation(libs.espresso.core) // Usando el alias para espresso-core
}
