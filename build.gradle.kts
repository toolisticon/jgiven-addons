plugins {
  base
  idea
  kotlin("jvm") apply false
}

allprojects {
  group = "io.toolisticon.addons.jgiven"

  apply {
    from("${rootProject.rootDir}/gradle/repositories.gradle.kts")
  }
}

dependencies {
  subprojects.forEach {
    archives(it)
  }
}
