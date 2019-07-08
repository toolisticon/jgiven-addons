plugins {
    base
    idea
//    kotlin("jvm") version Versions.kotlin apply false
    id("nebula.release") version "10.1.2"
    id("nebula.kotlin") version "1.3.40" apply false
    id("org.jmailen.kotlinter") version "1.26.0" apply false
    id("info.solidsoft.pitest") version "1.4.0" apply false
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

