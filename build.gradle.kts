plugins {
    base
    idea
    kotlin("jvm") version Versions.kotlin

    `maven-publish`

    githubRelease()
}

group="com.github.jangalinski"
version="0.2.1-SNAPSHOT"

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
    setToken(properties["github.token"] as String)
    setPrerelease(true)
    setOverwrite(true)
    setPrerelease((project.version as String).endsWith("-SNAPSHOT"))
}
