plugins {
  base
  idea
  `build-scan`

  kotlin("jvm") version Versions.kotlin apply false
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

buildScan {
  termsOfServiceUrl = "https://gradle.com/terms-of-service"
  termsOfServiceAgree = "yes"
  publishAlways()
}
