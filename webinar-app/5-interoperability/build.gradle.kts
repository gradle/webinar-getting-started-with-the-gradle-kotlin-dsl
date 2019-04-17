import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.21" apply false
}

subprojects {

    repositories {
        jcenter()
    }

    apply(from = rootProject.file("gradle/licensing.gradle"))
    apply(plugin = "org.jetbrains.kotlin.jvm")

    dependencies {
        val implementation by configurations
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        val testImplementation by configurations
        testImplementation("org.jetbrains.kotlin:kotlin-test")
        testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
    }

    tasks {
        named("compileKotlin", KotlinCompile::class) {
            kotlinOptions {
                allWarningsAsErrors = true
            }
        }
    }
}
