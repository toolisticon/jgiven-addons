plugins {
  base
  idea
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
