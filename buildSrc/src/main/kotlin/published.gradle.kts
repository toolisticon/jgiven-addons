import com.jfrog.bintray.gradle.BintrayExtension

plugins {
  id("org.jetbrains.dokka")
  id("nebula.maven-publish")
  id("nebula.source-jar")
  id("nebula.nebula-bintray-publishing")
}

plugins.withId("kotlin") {
  tasks.withType<Javadoc> {
    enabled = false
  }

  tasks.dokka  {
    outputFormat = "html"
    outputDirectory = "$buildDir/javadoc"
    jdkVersion = 8
  }

  val dokkaJar = task<Jar>("dokkaJar") {
    group = "build"
    description = "Assembles Javadoc jar from Dokka API docs"
    archiveClassifier.set("javadoc")
    from(tasks.dokka)
  }

  publishing {
    publications {
      getByName<MavenPublication>("nebula") {
        artifact(dokkaJar)
      }
    }
  }
}

publishing {
  publications {
    getByName<MavenPublication>("nebula") {
      pom {
        url.set("https://toolisticon.io/")
        licenses {
          license {
            name.set("The Apache License, Version 2.0")
            url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
          }
        }
        developers {
          developer {
            id.set("jangalinski")
            name.set("Jan Galinski")
            email.set("jan.galinski@holisticon.de")
          }
        }
        scm {
          connection.set("scm:git:git://github.com/toolisticon/jgiven-addons.git")
          developerConnection
            .set("scm:git:ssh://github.com/toolisticon/jgiven-addons.git")
          url.set("http://github.com/toolisticon/jgiven-addons/")
        }
      }
    }
  }
}

bintray {
  user = System.getenv("BINTRAY_USER")
  key = System.getenv("BINTRAY_KEY")
  pkg(delegateClosureOf<BintrayExtension.PackageConfig> {
    userOrg = "toolisticon"
    repo = "maven"
    websiteUrl = "https://toolisticon.io/"
    issueTrackerUrl = "https://github.com/toolisticon/jgiven-addons/issues"
    vcsUrl = "https://github.com/toolisticon/jgiven-addons.git"
    setLicenses("Apache-2.0")
    setLabels("testing", "kotlin")
  })
}
