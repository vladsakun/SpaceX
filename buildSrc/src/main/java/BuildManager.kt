import org.gradle.api.Plugin
import org.gradle.api.Project

class BuildManager : Plugin<Project> {
    override fun apply(project: Project) {
//        project.task("renameApk") {
//            doLast {
//                val apkPath = "/outputs/apk/release/app-release-unsigned-bla-bla.apk"
//                val renamedApkPath = "/outputs/apk/release/RenamedAPK.apk"
//                val previousApkPath = "${project.buildDir.absoluteFile}$apkPath"
//                val newPath = File(previousApkPath)
//
//                if (newPath.exists()) {
//                    val newApkName = "${project.buildDir.absoluteFile}$renamedApkPath"
//                    newPath.renameTo(File(newApkName))
//                } else {
//                    println("Path does not exist!")
//                }
//            }
//        }.dependsOn("build")
    }
}