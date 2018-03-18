val assertJVersion = "3.9.1"
val junitPlatformVersion = "1.0.1"
val junitJupiterVersion = "5.1.0"
val springBootVersion = "2.0.0.RELEASE"

plugins {
  val kotlinVersion = "1.2.30"
  id("org.jetbrains.kotlin.jvm") version kotlinVersion
  java
  idea
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

  testImplementation("org.assertj:assertj-core:$assertJVersion")
  testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
  testImplementation("org.springframework.boot:spring-boot-starter-test:$springBootVersion") {
    exclude("junit:junit")
  }

  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
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

tasks.withType<Test> {
  useJUnitPlatform()
}

tasks.withType<Jar> {
  configurations["compileClasspath"].forEach { file: File ->
    from(zipTree(file.absoluteFile))
  }
  manifest {
    attributes(
        mapOf(
            "Main-Class" to "net.lab0.shell.Application"
        )
    )
  }
}

