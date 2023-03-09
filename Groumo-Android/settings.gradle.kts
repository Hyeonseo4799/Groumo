pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://devrepo.kakao.com/nexus/content/groups/public/") }
    }
    versionCatalogs {
        create("libs") {
            from(files("./gradle/versions.toml"))
        }
    }
}
rootProject.name = "Groumo"
include(":app")
include(":feature:login")
include(":core:network")
include(":core:data")
include(":core:domain")
include(":core:model")
include(":core:common")
include(":core:designsystem")
include(":feature:group")
include(":feature:search")
include(":feature:home")
include(":feature:mypage")
include(":feature:trading")
