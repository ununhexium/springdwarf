import org.gradle.internal.impldep.org.junit.experimental.categories.Categories.CategoryFilter.include
import org.junit.platform.console.options.Details
import org.junit.platform.gradle.plugin.JUnitPlatformExtension


val assertJVersion = "3.9.1"
val junitPlatformVersion = "1.0.1"
val junitJupiterVersion = "5.0.1"
val springBootVersion = "2.0.0.RELEASE"
val log4jVersion = "2.10.0"

plugins {
  val kotlinVersion = "1.2.30"
  id("org.jetbrains.kotlin.jvm") version kotlinVersion
  java
  idea
}


apply {
  plugin("org.junit.platform.gradle.plugin")
}

idea {
  module {
    isDownloadSources = true
  }
}

repositories {
  mavenCentral()
  jcenter()
}

version = "0.1.0-SNAPSHOT"

dependencies {
  compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  compile("org.jetbrains.kotlin:kotlin-reflect")
  compile("org.springframework.boot:spring-boot-starter-parent:$springBootVersion")
  compile("org.springframework.shell:spring-shell-starter:$springBootVersion")

  compile("org.assertj:assertj-core:$assertJVersion")
  testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
  testImplementation("org.springframework.boot:spring-boot-starter-test:$springBootVersion") {
    exclude("junit:junit")
  }

  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
  // To use Log4J's LogManager
  testRuntimeOnly("org.apache.logging.log4j:log4j-core:$log4jVersion")
  testRuntimeOnly("org.apache.logging.log4j:log4j-jul:$log4jVersion")
}

buildscript {
  repositories {
    mavenCentral()
    jcenter()
  }
  dependencies {
    classpath("org.junit.platform:junit-platform-gradle-plugin:1.0.+")
  }
}


extensions.getByType(JUnitPlatformExtension::class.java).apply {
  filters {
    engines {
      include("junit-jupiter")
    }
  }
  logManager = "org.apache.logging.log4j.jul.LogManager"
  details = Details.TREE
}
