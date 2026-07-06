plugins {
    id("java")
    id("io.freefair.lombok")version "9.5.0"
    //En el gradle options, en Tasks->distribution-installDist
    //Para crear un ejecutable, se guarda en el build->install-->"nombreProyecto"
    //Para ejecutar, en la carpeta raiz(fuera de bin y lib), abrir cmd y ejecutar java -cp ./lib/* uce.edu.ec.RestPostMain
    //O en el cmd, ejecutar el archivo bin del bin añadiendo la direccion de la clase
    id("application")

    //----Con plugin-----
    //Lo mismo pero ejecutando el installShadowDist
    //Añadir tasks.jar{ con manifest{["Main-Class"}="direccion de la clase"}
    //Con cmd en el lib ejecutar "java -jar rest-post-1.0-all.jar"
    //Agregar en el archivo beans.xml ="bean-discovery-mode="all"
    id("com.gradleup.shadow") version "9.5.1"


    //Descargar nginx, abrir cmd en la carpeta del nginx, ejecutar con "nginx", creara un servidor con direccion "localhost"
    //En la parte web, "react07", ejecutar npm run build dist, creara la carpeta dist, copiar el contenido a la carpeta html de nginx
}

group = "uce.edu.ec"
version = "1.0"

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

tasks.jar {
    manifest {
        attributes["Main-Class"] = "uce.edu.ec.RestPostMain"
    }

}
