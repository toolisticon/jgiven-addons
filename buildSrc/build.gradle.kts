plugins {
  `java-gradle-plugin`
  `kotlin-dsl`
  `kotlin-dsl-precompiled-script-plugins`
}

apply {
  from("../gradle/repositories.gradle.kts")
}

kotlinDslPluginOptions {
  experimentalWarning.set(false)
}

repositories {
  jcenter()
  gradlePluginPortal()
}

dependencies {
  compile("org.jetbrains.dokka:dokka-gradle-plugin:0.9.18")
  compile("com.netflix.nebula:nebula-publishing-plugin:9.4.6")
  compile("com.netflix.nebula:nebula-bintray-plugin:5.0.0")
  compile("com.ferranpons:twitter-gradle-plugin:1.1.0")
}
