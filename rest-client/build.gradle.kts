plugins {
    id("java")
    id("io.freefair.lombok")version "9.5.0"
}

group = "ec.edu.uce"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
val weldVersion ="6.0.4.Final"
val hibernateVersion = "7.4.1.Final"
val restEasyVersion = "7.0.2.Final"
val deltaSpikeVersion ="2.0.1"

dependencies {
    //--REST
    implementation("org.jboss.resteasy:resteasy-core:${restEasyVersion}")
    implementation("org.jboss.resteasy:resteasy-json-binding-provider:${restEasyVersion}")


}

tasks.test {
    useJUnitPlatform()
}