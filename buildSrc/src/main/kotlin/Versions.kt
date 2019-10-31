import org.gradle.api.JavaVersion
import org.gradle.kotlin.dsl.embeddedKotlinVersion

object Versions {

  val java = JavaVersion.VERSION_1_8.toString()
  val kotlin = embeddedKotlinVersion
  val jgiven = "0.18.2"

  val junit5 = "5.5.2"

  object Plugin {
    val dokka = "0.10.0"
    val bintray = "1.8.4"
  }
}
