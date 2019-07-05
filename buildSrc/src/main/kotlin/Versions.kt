import org.gradle.kotlin.dsl.embeddedKotlinVersion

object Versions {

  val kotlin = embeddedKotlinVersion
  val jgiven = "0.17.1"

  object plugin {
    val githubRelease = "2.2.9"
  }
}