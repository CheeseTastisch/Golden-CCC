plugins {
    id("java")
}

group = "me.lian"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":Frame"))
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}