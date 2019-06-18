repositories {

  // prefer artifacts from local cache
  mavenLocal()

  // if not found, search on jcenter
  jcenter()

  maven {
    setUrl("https://dl.bintray.com/toolisticon/toolisticon")
  }

  maven {
    setUrl("https://jitpack.io")
  }
}
