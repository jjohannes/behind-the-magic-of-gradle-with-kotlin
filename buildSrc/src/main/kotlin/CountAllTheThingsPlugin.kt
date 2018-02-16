
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.attributes.Attribute
import org.gradle.kotlin.dsl.createTask
import java.io.File

open class CountAllTheThingsPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            val allThings = configurations.create("allThings")
            val androidThings = configurations.create("androidThings")
            allThings.extendsFrom(androidThings)

            val listTask = createTask("listThings", ListAllThingsTask::class) { }
            createTask("countThings", CountAllThingsTask::class) {
                listFile = listTask.outputs.files
                moreListFiles = allThings
            }
            createTask("countAndroidThings", CountAllThingsTask::class) {
                listFile = listTask.outputs.files
                moreListFiles = androidThings
                countFile = File(project.buildDir, "countAndroid.txt")
            }
            artifacts.add("allThings", listTask.listFile) {
                builtBy(listTask)
            }

            val attribute = Attribute.of(Scope::class.java)
            androidThings.attributes.attribute(attribute, Scope.ANDROID)
            allThings.attributes.attribute(attribute, Scope.ALL)
        }
    }

    enum class Scope {
        ANDROID,
        ALL
    }
}