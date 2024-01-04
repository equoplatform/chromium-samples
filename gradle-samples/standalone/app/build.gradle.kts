
var platform = ""
var vmArgs = "-Dempty"
val chromiumVersion = "106.0.22"
val chromiumPlatformVersion = "106.0.20"
val os = System.getProperty("os.name").toLowerCase()
if (os.contains("linux")) {
    platform = "gtk.linux"
} else if (os.contains("mac")) {
    platform = "cocoa.macosx"
    vmArgs = "-XstartOnFirstThread"
} else if (os.contains("windows")) {
    platform = "win32.win32"
}
val arch = when {
    System.getProperty("os.arch").toLowerCase().contains("amd64") -> "x86_64"
    else -> System.getProperty("os.arch").toLowerCase()
}

plugins {
    kotlin("jvm") version "1.5.10"
    application
}

repositories {
    mavenCentral()
    maven(url = "https://dl.equo.dev/chromium-swt-ee/equoSamples/mvn")
}

dependencies {
    implementation("com.equo:com.equo.chromium.cef.${platform}.${arch}:${chromiumPlatformVersion}")
    implementation("com.equo:com.equo.chromium:${chromiumVersion}")
}

application {
    applicationDefaultJvmArgs = listOf("${vmArgs}")
    mainClass.set("Standalone.StandaloneKt")
}
