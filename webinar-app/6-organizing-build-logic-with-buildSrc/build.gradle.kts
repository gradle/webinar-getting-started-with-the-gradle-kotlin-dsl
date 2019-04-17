subprojects {

    repositories {
        jcenter()
    }

    apply(from = rootProject.file("gradle/licensing.gradle"))

    apply(plugin = "kotlin-conventions")
}
