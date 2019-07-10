plugins {
  kotlin("jvm")
  `java-library`

  published
}

dependencies {
  api("com.tngtech.jgiven:jgiven-core:${Versions.jgiven}")
  implementation(kotlin("stdlib-jdk8"))
}


