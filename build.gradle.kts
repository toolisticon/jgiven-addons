plugins {
    base
    idea
    kotlin("jvm") version Versions.kotlin

    `maven-publish`

    githubRelease()
}

group="com.github.jangalinski"
version="0.3.0"

apply {
    from("${rootProject.rootDir}/gradle/repositories.gradle.kts")
}

dependencies {
    api("com.tngtech.jgiven:jgiven-core:${Versions.jgiven}")
    implementation(kotlin("stdlib-jdk8"))
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
    setToken(properties["github.token"] as String)
    setPrerelease(true)
    setOverwrite(true)
    setPrerelease((project.version as String).endsWith("-SNAPSHOT"))
}
