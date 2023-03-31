plugins {
	java
	id("org.springframework.boot") version "3.0.5"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "com.isanghaessi"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
  runtimeOnly("org.springframework.boot:spring-boot-devtools")
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.1")
	implementation("com.mysql:mysql-connector-j")
	implementation("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
}

sourceSets {
	main {
		resources {
			setSrcDirs(listOf("src/main/java", "src/main/resources"))
			setIncludes(listOf("**/mapper/*.xml", "**/application.yml"))
		}
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.bootRun {
  doFirst {
    if (project.hasProperty("jvmArgs")) {
      jvmArgs = (project.property("jvmArgs") as String).split("\\s+".toRegex())
    }
  } 
}