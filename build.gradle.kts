plugins {
    base
    idea

    id("nebula.release") version "10.1.2"
    id("nebula.kotlin") version Versions.kotlin apply false
    id("com.github.ben-manes.versions") version "0.21.0"
}

allprojects {
    group = "io.toolisticon.addons"
   // version = "0.1.0-SNAPSHOT"

    apply {
        from("${rootProject.rootDir}/gradle/repositories.gradle.kts")
    }
}

dependencies {
    subprojects.forEach {
        archives(it)
    }
}
