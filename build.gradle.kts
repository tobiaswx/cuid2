plugins {
    kotlin("multiplatform") version "1.8.20-Beta"
    `maven-publish`
}

group = "com.sakoss.library"
version = "2.0.0-RC1"

repositories {
    mavenCentral()
}

publishing {
    publications.withType<MavenPublication> {
        pom {
            name.set("cuid2")
            description.set("Kotlin Cuid2 MultiPlatform Library")
            url.set("https://github.com/Sakoss-Developers/cuid")

            licenses {
                license {
                    name.set("LGPL-2.1 license")
                    url.set("https://github.com/Sakoss-Developers/cuid/blob/main/LICENSE")
                }
            }
            scm {
                url.set("https://github.com/Sakoss-Developers/cuid")
            }
        }
    }
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
