plugins {
    kotlin("jvm") version "2.3.20"
    id("io.freefair.lombok")  version "9.5.0"
}

group = "uce.edu.ec"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    //json: Encargado de transformar a json
    implementation("org.jboss.resteasy:resteasy-json-binding-provider:7.0.2.Final")
    implementation("org.jboss.resteasy:resteasy-core-spi:7.0.2.Final")
    implementation("org.jboss.resteasy:resteasy-jaxb-provider:7.0.2.Final")

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