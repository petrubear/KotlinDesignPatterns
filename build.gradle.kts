plugins {
    id("org.jetbrains.kotlin.jvm") version "1.7.10"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}

val cleanVsCodeJars = tasks.register<Delete>("cleanVsCodeRunnerJars") {
    val tree = fileTree("src/main/kotlin/")
    tree.include("**/*.jar")
    tree.forEach { delete(it) }

    doFirst {
        println("clean vscode jars")
    }
}

tasks.named("clean") {
    dependsOn(cleanVsCodeJars)
}
