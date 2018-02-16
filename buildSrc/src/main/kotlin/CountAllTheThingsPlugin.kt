
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.createTask

open class CountAllTheThingsPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            val listTask = createTask("listThings", ListAllThingsTask::class) { }
            createTask("countThings", CountAllThingsTask::class) {
                listFile = listTask.outputs.files
            }
        }
    }
}