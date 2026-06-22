plugins {
    id("java")
}

group = "uce.edu.ec"
version = "unspecified"

repositories {
    mavenCentral()
}
val weldVersion ="6.0.4.Final"
val hibernateVersion = "7.4.1.Final"
val restEasyVersion = "7.0.2.Final"

dependencies {
    //json: Encargado de transformar a json

    implementation("org.jboss.resteasy:resteasy-core-spi:7.0.2.Final")
    implementation("org.jboss.resteasy:resteasy-jaxb-provider:7.0.2.Final")
    //CDI
    implementation("org.jboss.weld.se:weld-se-core:${weldVersion}")
    //JPA
    implementation("org.hibernate.orm:hibernate-core:${hibernateVersion}")

    implementation("org.jboss.resteasy:resteasy-core:${restEasyVersion}")
    implementation("org.jboss.resteasy:resteasy-undertow-cdi:${restEasyVersion}")
    implementation("org.jboss.resteasy:resteasy-json-binding-provider:${restEasyVersion}")
}

tasks.test {
    useJUnitPlatform()
}