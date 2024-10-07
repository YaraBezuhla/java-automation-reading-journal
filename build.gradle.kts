plugins {
    id("java")
}

group = "journal.reading.automation"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.testng:testng:7.10.2")
    implementation("org.seleniumhq.selenium:selenium-java:4.25.0")
}

/*tasks.test {
    useJUnitPlatform()
}*/