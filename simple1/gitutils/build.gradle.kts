plugins {
    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.slf4j:slf4j-api:1.7.2")
    implementation("org.eclipse.jgit:org.eclipse.jgit:5.3.0.201903130848-r")

    testImplementation("org.junit.jupiter:junit-jupiter:5.4.1")
    testRuntimeOnly("org.slf4j:slf4j-simple:1.7.2")
}

tasks.test {
    useJUnitPlatform()
}
