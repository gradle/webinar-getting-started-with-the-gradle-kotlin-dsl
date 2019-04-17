rootProject.name = "webinar-app"

includeBuild("../build-logic")

gradle.rootProject {
    buildscript {
        dependencies {
            classpath("webinar:build-logic:1.0")
        }
        repositories {
            gradlePluginPortal()
        }
    }
}

include(
    "app",
    "core"
)
