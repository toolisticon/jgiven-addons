package com.github.jangalinski.jgiven.kotlin

import com.tngtech.jgiven.Stage
import com.tngtech.jgiven.base.ScenarioTestBase

/**
 * Use `GIVEN` instead of `given()` on Given-Stage "G"
 */
val <G : Stage<G>, W : Stage<W>, T : Stage<T>> ScenarioTestBase<G, W, T>.GIVEN: G get() = given()
/**
 * Use `WHEN` instead of `when()` on When-Stage "W"
 */
val <G : Stage<G>, W : Stage<W>, T : Stage<T>> ScenarioTestBase<G, W, T>.WHEN: W get() = `when`()
/**
 * Use `THEN` instead of `then()` on Then-Stage "T"
 */
val <G : Stage<G>, W : Stage<W>, T : Stage<T>> ScenarioTestBase<G, W, T>.THEN: T get() = then()

val <X : Stage<X>> Stage<X>.AND: X get() = and()
val <X : Stage<X>> Stage<X>.WITH: X get() = with()
val <X : Stage<X>> Stage<X>.BUT: X get() = but()

/**
 * Marker annotation for all-open compiler plugin.
 */
internal annotation class JGivenKotlinStage
