plugins {
    application
}

dependencies {
    implementation(project(":core"))
}

application {
    mainClassName = "webinar.app.AppKt"
    applicationDefaultJvmArgs = listOf("-Xmx4m")
}

licensing {
    withGroovyBuilder {
        "license"("GPL")
    }
}
