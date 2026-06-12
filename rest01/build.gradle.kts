plugins {
    kotlin("jvm") version "2.3.20"
}

group = "uce.edu.ec"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jboss.resteasy:resteasy-core:7.0.2.Final")
    implementation("org.jboss.resteasy:resteasy-undertow:7.0.2.Final")
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(25)
}

tasks.test {
    useJUnitPlatform()
}