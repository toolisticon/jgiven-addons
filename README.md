# jgiven-addons

[ ![Download](https://api.bintray.com/packages/toolisticon/maven/jgiven-addons/images/download.svg?version=0.4.1) ](https://bintray.com/toolisticon/maven/jgiven-addons/0.4.1/link)

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
