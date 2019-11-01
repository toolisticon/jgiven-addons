import toolisticon.PublishLibraryPlugin

plugins {
  kotlin("jvm")
}

apply<PublishLibraryPlugin>()

dependencies {
  api("com.tngtech.jgiven:jgiven-core:${Versions.jgiven}")
  implementation(kotlin("stdlib-jdk8"))
}
