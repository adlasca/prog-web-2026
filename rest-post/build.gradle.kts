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
val deltaSpikeVersion ="2.0.1"

dependencies {
    //json: Encargado de transformar a json

    implementation("org.jboss.resteasy:resteasy-core-spi:7.0.2.Final")
    implementation("org.jboss.resteasy:resteasy-jaxb-provider:7.0.2.Final")
    //CDI
    implementation("org.jboss.weld.se:weld-se-core:${weldVersion}")
    //JPA
    implementation("org.hibernate.orm:hibernate-core:${hibernateVersion}")

    implementation("org.projectlombok:lombok:1.18.46")

    implementation("org.jboss.resteasy:resteasy-core:${restEasyVersion}")
    implementation("org.jboss.resteasy:resteasy-undertow-cdi:${restEasyVersion}")
    implementation("org.jboss.resteasy:resteasy-json-binding-provider:${restEasyVersion}")
    implementation("org.apache.deltaspike.core:core-project:2.0.1")
    implementation("org.apache.deltaspike.modules:deltaspike-data-module-api:${deltaSpikeVersion}")
    implementation("org.apache.deltaspike.modules:deltaspike-data-module-impl:${deltaSpikeVersion}")
    implementation("org.postgresql:postgresql:42.7.3")

    compileOnly("org.projectlombok:lombok:1.18.46")
    annotationProcessor("org.projectlombok:lombok:1.18.46")
}

tasks.withType<JavaCompile> {
    options.release.set(21)
}

sourceSets{
    main{
        output.setResourcesDir(
            file("${buildDir}/classes/java/main")
        )
    }
}
