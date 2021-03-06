plugins {
    `maven-publish`
    idea
    kotlin("jvm") version "1.3.72"
    id("pl.allegro.tech.build.axion-release") version "1.12.1"
    id("com.github.ben-manes.versions") version "0.28.0"
    id("com.jfrog.bintray") version "1.8.4"
}

apply {
    from("axion-release-config.gradle")
}

group = "se.svt.oss"
version = scmVersion.version

tasks.test {
    useJUnitPlatform()
}


repositories {
    jcenter()
    mavenCentral()
}

// test feature branch should not sync
dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
    gradleVersion = "6.4.1"
}
