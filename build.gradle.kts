import java.io.FilenameFilter

plugins {
    base
    idea
    kotlin("jvm") version Versions.kotlin

    `maven-publish`

    id("com.github.breadmoirai.github-release") version "2.2.9"
}

group="com.github.jangalinski"
version="0.2.0"

apply {
    from("${rootProject.rootDir}/gradle/repositories.gradle.kts")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation("com.tngtech.jgiven:jgiven-core:${Versions.jgiven}")
}



val sourcesJar by tasks.registering(Jar::class) {
    classifier = "sources"
    from(sourceSets.main.get().allSource)
}

publishing {
    repositories {
        maven {
            url = uri("$buildDir/repo")
        }
    }
    publications {
        register("mavenJava", MavenPublication::class) {
            from(components["java"])
            artifact(sourcesJar.get())
        }
    }
}

githubRelease {
    //val token = getProperty("github.token") as String

    setPrerelease(true)
    setOverwrite(true)

}