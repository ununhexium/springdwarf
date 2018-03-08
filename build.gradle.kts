import org.gradle.internal.impldep.org.junit.experimental.categories.Categories.CategoryFilter.include
import org.junit.platform.console.options.Details
import org.junit.platform.gradle.plugin.JUnitPlatformExtension

val junitPlatformVersion = "1.0.1"
val junitJupiterVersion  = "5.0.1"
val log4jVersion = "2.9.1"

plugins {
    val kotlinVersion = "1.2.30"
    id("org.jetbrains.kotlin.jvm") version kotlinVersion
    java
}

repositories {
    mavenCentral()
    jcenter()
}

version = "0.1.0-SNAPSHOT"

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    compile("org.jetbrains.kotlin:kotlin-reflect")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.+")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.+")
    testRuntimeOnly("org.junit.platform:junit-platform-engine:1.+")

    testImplementation("org.junit.jupiter:junit-jupiter-api:${junitJupiterVersion}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitJupiterVersion}")

    // To use Log4J"s LogManager
    testRuntimeOnly("org.apache.logging.log4j:log4j-core:${log4jVersion}")
    testRuntimeOnly("org.apache.logging.log4j:log4j-jul:${log4jVersion}")
}

buildscript {
    repositories {
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath("org.junit.platform:junit-platform-gradle-plugin:1.0.1")
    }
}

apply {
    plugin("org.junit.platform.gradle.plugin")
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
