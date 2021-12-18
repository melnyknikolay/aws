plugins {
    java
    eclipse
}

allprojects {
    group = "it.discovery"
}

subprojects {
    apply(plugin = "java")

    java.sourceCompatibility = JavaVersion.VERSION_17
    java.targetCompatibility = JavaVersion.VERSION_17

    repositories {
        jcenter()
    }

    dependencies {
        implementation(platform("org.springframework.boot:spring-boot-dependencies:2.6.1"))
        implementation(platform("software.amazon.awssdk:bom:2.17.99"))
    }

    tasks.test {
        useJUnitPlatform()
    }
}

