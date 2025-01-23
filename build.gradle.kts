plugins {
    id("org.jetbrains.kotlin.jvm") version "2.1.0" apply false // Kotlin version to use
    id("java") apply true
}
subprojects { // configuration for all subprojects

    plugins.apply("org.jetbrains.kotlin.jvm")

    dependencies {
        // under 3 dependencies needed for logging on console
        implementation("io.github.oshai:kotlin-logging-jvm:6.0.9")
        implementation("ch.qos.logback:logback-classic:1.5.6")
        implementation("ch.qos.logback:logback-core:1.5.6")

        testImplementation("org.junit.jupiter:junit-jupiter:5.10.2") // for test framework
    }

    tasks.test { // configuration for running tests
        useJUnitPlatform()
    }

    repositories {
        mavenCentral()
    }
}

