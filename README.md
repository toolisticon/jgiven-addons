# Archived JGiven-addons

**This repository is archived and discontinued. JGiven-Kotlin is still maintained, until it is supported by JGiven. You find the latest version of JGiven-Kotlin, in this github repository: https://github.com/toolisticon/jgiven-kotlin In a meantime there is a version released to Maven Central.**

[![sponsored](https://img.shields.io/badge/sponsoredBy-Holisticon-RED.svg)](https://holisticon.de/)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.toolisticon.testing/jgiven-kotlin/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.toolisticon.testing/jgiven-kotlin)

a kotlin extension for the JVM BDD testing tool [jgiven](http://jgiven.org/)

## Features

### GIVEN,WHEN,THEN

when using kotlin, instead of 

```
given()
  .some_facts()

`when`()  // when is a keyword in kotlin
  .something_happens()

then()
  .expect_a_result()

```

you can simply use the dynamic extension properties:

```
GIVEN
  .some_facts();

WHEN
  .something_happens()

THEN
  .expect_a_result()
```

### Writing Stages

In jgiven-java, you have to do:

```
class MyStage extends Stage<MyStage> {

  MyStage my_step() {
     // what the step does
     return self();
  }
}
```

jgiven-kotlin introduces the inline extension function `step()`, so this can be simplified to:

```
@JGivenKotlinStage
class MyStage : Stage<MyStage>() {

  fun `my step`() = step {
     // what the step does
  }
}
```

### JGivenKotlinStage annotation

Since all classes and functions are final by default in kotlin,
you have to explicitly mark everything you write in a Stage to be `open`.

Using the `JGivenKotlinStage` annotation and kotlins "all-open" compiler
plugin, this can be avoided.

```
plugins {
  id("org.jetbrains.kotlin.plugin.allopen") version <kotlin_version>
}

...

allOpen {
  annotation("io.toolisticon.addons.jgiven.JGivenKotlinStage")
}

```

## Hints

This extension might become obsolete once jgiven [supports this officially](https://github.com/TNG/JGiven/pull/407)


