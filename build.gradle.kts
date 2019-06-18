plugins {
    base
    idea
    kotlin("jvm") version Versions.kotlin
}

apply {
    from("${rootProject.rootDir}/gradle/repositories.gradle.kts")
}

repositories {
    // Use jcenter for resolving your dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation("com.tngtech.jgiven:jgiven-core:${Versions.jgiven}")

}
