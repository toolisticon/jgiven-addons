package toolisticon

import Github
import com.jfrog.bintray.gradle.BintrayExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaBasePlugin
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.publish.maven.tasks.PublishToMavenLocal
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.api.tasks.bundling.Jar
import org.gradle.kotlin.dsl.*
import org.jetbrains.dokka.gradle.DokkaTask
import withXml
import java.util.*

open class PublishLibraryPlugin : Plugin<Project> {
  override fun apply(project: Project) = with(project) {
    apply(plugin = "maven-publish")
    apply(plugin = "java-library")
    apply(plugin = "org.jetbrains.dokka")

    tasks {
      withType<DokkaTask> {
        outputFormat = "html"
        outputDirectory = "$buildDir/javadoc"
        enabled = JavaVersion.current().isJava8

        configuration {
          reportUndocumented = false
        }
      }

      register<Jar>("javadocJar") {
        group = JavaBasePlugin.DOCUMENTATION_GROUP
        description = "Assembles Kotlin docs with Dokka"
        archiveClassifier.set("javadoc")
        from(tasks["dokka"])
        dependsOn(tasks["dokka"])
      }

      register<Jar>("sourcesJar") {
        archiveClassifier.set("sources")
        from(this@with.the<SourceSetContainer>()["main"].allSource)
      }

      withType<PublishToMavenLocal> {
        dependsOn(tasks["build"])
      }
    }

    configure<PublishingExtension> {
      publications {
        create<MavenPublication>(project.name) {
          artifactId = project.name
          from(components["java"])
          artifact(tasks["javadocJar"])
          artifact(tasks["sourcesJar"])

          pom.withXml(
              name = "${rootProject.name}/${project.name}",
              description = ""
          )
        }
      }
    }

    project.addBintray()
  }


  private fun Project.addBintray() {
    apply(plugin = "com.jfrog.bintray")

    configure<BintrayExtension> {
      user = propertySafe("bintrayUser")
      key = propertySafe("bintrayKey")
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
  }
}


fun Project.propertySafe(propertyName: String, fallbackToEmpty: Boolean = true): String {
  val rawValue = properties[propertyName]
  return if (rawValue == null) {
    if (fallbackToEmpty) {
      return ""
    }
    throw IllegalStateException("Property $propertyName MUST be initialized.")
  } else {
    if (rawValue is String) {
      rawValue
    } else {
      rawValue.toString()
    }
  }
}
