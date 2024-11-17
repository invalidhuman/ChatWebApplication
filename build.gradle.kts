plugins {
	java
	id("org.springframework.boot") version "3.3.5"
	id("io.spring.dependency-management") version "1.1.6"
	id("java")
}


group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// Springframework
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("org.springframework.boot:spring-boot-starter-freemarker")
	implementation("org.springframework.boot:spring-boot-devtools")

	// webjars
	implementation("org.webjars:webjars-locator-core")
	implementation("org.webjars:stomp-websocket:2.3.3")
	implementation("org.webjars.bower:bootstrap:4.3.1")
	implementation("org.webjars.bower:vue:2.5.16")
	implementation("org.webjars.bower:axios:0.17.1")
	implementation("org.webjars:sockjs-client:1.1.2")
	implementation("org.webjars:jquery:3.1.1-1")

	// ?
	implementation("com.google.code.gson:gson:2.8.9")

	// Websocket
	implementation("org.springframework.boot:spring-boot-starter-websocket")

	// lombok
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	// DB
	runtimeOnly("com.h2database:h2")

	// test
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
