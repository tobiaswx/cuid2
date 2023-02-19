plugins {
    kotlin("multiplatform") version "1.8.20-Beta"
}

group = "com.sakoss.library"
version = "2.0.0"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js(IR) {
        nodejs()
        browser()
    }
    
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("io.github.thibaultmeyer:cuid:2.0.1")
            }
        }
        val jvmTest by getting
        val jsMain by getting {
            dependencies {
                implementation(npm("@paralleldrive/cuid2", "latest"))
            }
        }
        val jsTest by getting
    }
}
