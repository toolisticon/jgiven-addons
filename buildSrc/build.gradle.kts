plugins {
  `java-gradle-plugin`
  `kotlin-dsl`
}

apply {
  from("../gradle/repositories.gradle.kts")
}

kotlinDslPluginOptions {
  experimentalWarning.set(false)
}


dependencies {
  implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$embeddedKotlinVersion")
  implementation("org.jetbrains.dokka:dokka-gradle-plugin:0.10.0")
  implementation("com.jfrog.bintray.gradle:gradle-bintray-plugin:1.8.4")
}
