plugins {
    id("com.android.application") version "8.1.4"
    id("org.jetbrains.kotlin.android") version "1.9.22"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.22"
}

android {
    namespace = "com.jarvis.assistant"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.jarvis.assistant"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    // 🌟 핵심: 루트 전체(".")가 아닌 특정 폴더/파일 경로로 한정하여 build/ 디렉터리 간섭 차단
    sourceSets {
        getByName("main") {
            manifest.srcFile("AndroidManifest.xml")
            
            // 소스 코드는 루트 디렉터리를 포함하되
            java.srcDirs(".")
            
            // res 폴더는 루트 전체 대신 res/ 폴더가 있다면 그쪽을 가리키게 하거나
            // res 디렉터리 경로를 명확히 분리합니다.
            res.srcDirs("res") 
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    
    // Compose BOM
    implementation(platform("androidx.compose:compose-bom:2024.02.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    debugImplementation("androidx.compose.ui:ui-tooling")
    
    // 추가 라이브러리
    implementation("com.google.android.gms:play-services-location:21.0.1")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
}
