plugins {
    base
    idea

    id("nebula.release") version "10.1.2"
    id("nebula.kotlin") version Versions.kotlin apply false
}

allprojects {
    group = "io.toolisticon.addons"
    version = "0.1.0-SNAPSHOT"

    apply {
        from("${rootProject.rootDir}/gradle/repositories.gradle.kts")
    }
}

dependencies {
    subprojects.forEach {
        archives(it)
    }
}

