import org.gradle.kotlin.dsl.embeddedKotlinVersion

object Versions {

  val kotlin = embeddedKotlinVersion
  val jgiven = "0.17.1"

  val junit5 = "5.4.2"

  object Plugin {
    val dokka = "0.9.17"
    val bintray = "1.8.4"
  }
}
