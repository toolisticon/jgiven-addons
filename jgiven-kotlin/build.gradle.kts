import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.util.Date

plugins {
  kotlin("jvm")
  `java-library`

  `maven-publish`
  id("org.jetbrains.dokka") version Versions.Plugin.dokka
  id("com.jfrog.bintray") version Versions.Plugin.bintray
}

dependencies {
  api("com.tngtech.jgiven:jgiven-core:${Versions.jgiven}")
  implementation(kotlin("stdlib-jdk8"))
}


tasks {
  dokka {
    outputFormat = "html"
    outputDirectory = "$buildDir/javadoc"

    configuration {
      moduleName = rootProject.name
    }
  }

  publishToMavenLocal {
    dependsOn(build)
  }

  withType<KotlinCompile> {
    kotlinOptions {
      jvmTarget = Versions.java
    }
  }
}

val dokkaJar by tasks.creating(Jar::class) {
  group = JavaBasePlugin.DOCUMENTATION_GROUP
  description = "Assembles Kotlin docs with Dokka"
  archiveClassifier.set("javadoc")
  from(tasks.dokka)
  dependsOn(tasks.dokka)
}

val sourcesJar by tasks.creating(Jar::class) {
  archiveClassifier.set("sources")
  from(sourceSets.getByName("main").allSource)
}

publishing {
  publications {
    create<MavenPublication>(project.name) {
      artifactId = project.name
      from(components["java"])
      artifact(dokkaJar)
      artifact(sourcesJar)

      pom.withXml(name = "${rootProject.name}/${project.name}", description = "Addons for jgiven test tool")
    }
  }
}

bintray {
  user = properties["bintrayUser"] as String
  key = properties["bintrayKey"] as String
  publish = true

  setPublications(project.name)

  pkg.apply {
    userOrg = Github.organization
    repo = "maven"
    name = rootProject.name
    setLicenses("Apache-2.0")
    setLabels("Kotlin", "jgiven", "addon")
    vcsUrl = Github.pomScmUrl
    websiteUrl = Github.pomUrl
    issueTrackerUrl = Github.pomIssueUrl
    githubRepo = Github.path
    githubReleaseNotesFile = Github.readme

    version.apply {
      name = project.version as String
      vcsTag = project.version as String
      desc = Github.pomDesc
      released = Date().toString()
    }
  }
}