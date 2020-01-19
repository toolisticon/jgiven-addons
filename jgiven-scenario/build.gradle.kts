import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import toolisticon.PublishLibraryPlugin
import java.util.Date

plugins {
  kotlin("jvm")
}

apply<PublishLibraryPlugin>()

dependencies {
  api("com.tngtech.jgiven:jgiven-junit5:${Versions.jgiven}")
  
  implementation(kotlin("stdlib-jdk8"))
  implementation("org.junit.jupiter:junit-jupiter-api:${Versions.junit5}")
}

tasks {
  withType<KotlinCompile> {
    kotlinOptions {
      jvmTarget = Versions.java
    }
  }

  withType<Test> {
    useJUnitPlatform()
  }
}
