pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "IMDB_top_250"
include(":androidApp")
include(":networking")
include(":domain")
include(":sharedFeature")
