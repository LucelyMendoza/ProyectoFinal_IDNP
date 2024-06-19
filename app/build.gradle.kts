plugins {
    alias(libs.plugins.androidApplication)
}

android {
<<<<<<< HEAD
    namespace = "com.idnp2024a.homestructure"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.idnp2024a.homestructure"
=======
    namespace = "com.idnp2024a.loginsample"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.idnp2024a.loginsample"
>>>>>>> main
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
<<<<<<< HEAD
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
=======
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
>>>>>>> main

    buildFeatures {
        viewBinding = true
    }
<<<<<<< HEAD

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
=======
>>>>>>> main
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
<<<<<<< HEAD
=======
    implementation(libs.gson)
>>>>>>> main
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}