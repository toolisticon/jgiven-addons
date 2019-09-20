plugins {
  base
  idea

  kotlin("jvm") version Versions.kotlin apply false

  `build-scan`
}

allprojects {
  group = "io.toolisticon.addons.jgiven"
  version = "0.5.3-SNAPSHOT"

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
