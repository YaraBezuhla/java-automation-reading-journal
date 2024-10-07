plugins {
    id("java")
}

group = "journal.reading.automation"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    implementation("org.seleniumhq.selenium:selenium-java:4.25.0")
    implementation("org.junit.jupiter:junit-jupiter-api:5.11.1")
}

tasks.test {
    useJUnitPlatform()
}