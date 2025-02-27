plugins {
    id("java")
}

group = "hu.dizs"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.guava:guava:33.4.0-jre")
    implementation("org.slf4j:slf4j-api:2.0.17")
    implementation("org.slf4j:slf4j-simple:2.0.17")

    testImplementation(platform("org.junit:junit-bom:5.12.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.platform:junit-platform-suite")
    testImplementation("io.cucumber:cucumber-java:7.20.1")
    testImplementation("io.cucumber:cucumber-junit:7.20.1")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.20.1")
}

tasks.test {
    useJUnitPlatform()
}
