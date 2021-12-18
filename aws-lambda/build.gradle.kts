dependencies {
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok:1.18.22")
    implementation("software.amazon.awssdk:lambda")
    implementation("com.amazonaws:aws-lambda-java-core:1.2.1")
    implementation("com.amazonaws:aws-lambda-java-events:2.2.9")
    implementation("com.amazonaws:aws-java-sdk-s3:1.12.128")
    implementation("org.apache.logging.log4j:log4j-api:2.15.0")
    implementation("org.apache.logging.log4j:log4j-core:2.15.0")
    runtimeOnly("org.apache.logging.log4j:log4j-slf4j18-impl:2.15.0")
    runtimeOnly("com.amazonaws:aws-lambda-java-log4j2:1.2.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
}

tasks.test {
    useJUnitPlatform()
}

tasks.register<Zip>("packageFat") {
    from(tasks.named("compileJava"))
    from(tasks.named("processResources"))

    from(configurations.runtimeClasspath) {
        into("lib")
    }

}

tasks.register<Zip>("packageLibs") {
    from(configurations.runtimeClasspath)
    into("lib")
}


/*
task packageFat(type: Zip) {
    from compileJava
    from processResources
    into("lib") {
        from configurations.runtimeClasspath
    }
    dirMode = 0755
    fileMode = 0755
} 

task packageLibs(type: Zip) {
    into("java/lib") {
        from configurations.runtimeClasspath
    }
    dirMode = 0755
    fileMode = 0755
} */

java.sourceCompatibility = JavaVersion.VERSION_11
java.targetCompatibility = JavaVersion.VERSION_11
