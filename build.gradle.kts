import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.0.2-SNAPSHOT"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.7.22"
	kotlin("plugin.spring") version "1.7.22"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	// Standard libraries
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	// Spring Boot
	implementation("org.springframework.boot:spring-boot-starter")

	// Web
	implementation("org.springframework.boot:spring-boot-starter-web")

	// Dev tools
	developmentOnly("org.springframework.boot:spring-boot-devtools")

	// Testing libraries
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.mockk:mockk:1.13.2")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
