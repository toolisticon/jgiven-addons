import org.gradle.plugin.use.PluginDependenciesSpec

fun PluginDependenciesSpec.githubRelease() = id("com.github.breadmoirai.github-release").version(Versions.plugin.githubRelease)
