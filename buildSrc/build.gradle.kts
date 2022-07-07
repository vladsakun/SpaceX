plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        create("BuildManager") {
            id = "com.applifting.spacex"
            implementationClass = "BuildManager"
            version = "1.0.0"
        }
    }
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation("com.android.tools.build:gradle:7.2.1")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    implementation("com.google.gms:google-services:4.3.13")
}