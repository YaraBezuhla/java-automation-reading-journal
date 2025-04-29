
plugins {
    id("java")
}

group = "journal.reading.automation"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.testng:testng:7.11.0")
    testImplementation("org.testng:testng:7.11.0")
    implementation("org.seleniumhq.selenium:selenium-java:4.25.0")
    implementation("org.mongodb:mongodb-driver-sync:5.2.0")
    implementation("io.qameta.allure:allure-testng:2.29.1")
    implementation("io.rest-assured:rest-assured:5.5.0")
    implementation("io.rest-assured:json-path:5.5.0")
    implementation("commons-io:commons-io:2.18.0")

}

tasks.test {
    useTestNG()
}

tasks.processTestResources {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}