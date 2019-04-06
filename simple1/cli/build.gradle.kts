plugins {
   java
   application
}

repositories {
   mavenCentral()
}

dependencies {
   implementation(project(":gitutils"))
   implementation("info.picocli:picocli:3.9.5")
}

application {
   mainClassName = "org.gradle.webinar.dm.cli.Main"
}

