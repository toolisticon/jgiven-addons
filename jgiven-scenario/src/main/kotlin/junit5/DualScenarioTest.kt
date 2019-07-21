package io.toolisticon.addons.jgiven.junit5

import com.tngtech.jgiven.impl.Scenario
import com.tngtech.jgiven.junit5.JGivenExtension
import com.tngtech.jgiven.junit5.SimpleScenarioTest
import io.toolisticon.addons.jgiven.DualScenarioTestBase
import org.junit.jupiter.api.extension.ExtendWith

/**
 * Convenience test base class for writing JGiven scenarios with JUnit 5.
 * If you only have one stage class you can also use the [SimpleScenarioTest] class.
 * If you don't want to inherit from any class you can just use the [JGivenExtension]
 * directly.
 *
 * @param <GIVEN_WHEN> the combined GIVEN and WHEN stage
 * @param <THEN> the THEN stage
 *
 * @see JGivenExtension
 *
 * @see SimpleScenarioTest
 */
@ExtendWith(JGivenExtension::class)
open class DualScenarioTest<GIVEN_WHEN, THEN> : DualScenarioTestBase<GIVEN_WHEN, THEN>() {
  private val scenario = createScenario()

  override fun getScenario(): Scenario<GIVEN_WHEN, GIVEN_WHEN, THEN> = scenario

}
