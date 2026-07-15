plugins {
    kotlin("jvm")
    application
    id("org.jetbrains.compose")
}

dependencies {
    implementation(project(":core"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")

    implementation(compose.desktop.currentOs)
    implementation(compose.material3)
    implementation(compose.animation)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

application {
    mainClass.set("com.game.puzzle.desktop.DesktopLauncherKt")
}

tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    manifest {
        attributes["Main-Class"] = "com.game.puzzle.desktop.DesktopLauncherKt"
    }
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}
