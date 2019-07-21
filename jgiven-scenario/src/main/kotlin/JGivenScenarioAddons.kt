package io.toolisticon.addons.jgiven

import com.google.common.reflect.TypeToken
import com.tngtech.jgiven.base.ScenarioTestBase
import com.tngtech.jgiven.impl.Scenario

abstract class DualScenarioTestBase<GIVEN_WHEN, THEN> : ScenarioTestBase<GIVEN_WHEN, GIVEN_WHEN, THEN>() {

  @Suppress("UNCHECKED_CAST")
  override fun createScenario(): Scenario<GIVEN_WHEN, GIVEN_WHEN, THEN> {
    val givenWhenClass = object : TypeToken<GIVEN_WHEN>(javaClass) {}.rawType as Class<GIVEN_WHEN>
    val thenClass = object : TypeToken<THEN>(javaClass) {}.rawType as Class<THEN>

    return Scenario(givenWhenClass, givenWhenClass, thenClass)
  }

}


