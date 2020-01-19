import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import toolisticon.PublishLibraryPlugin

plugins {
  kotlin("jvm")
}

apply<PublishLibraryPlugin>()

dependencies {
  api("com.tngtech.jgiven:jgiven-core:${Versions.jgiven}")
  implementation(kotlin("stdlib-jdk8"))
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
