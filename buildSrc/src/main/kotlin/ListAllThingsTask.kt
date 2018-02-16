import org.gradle.api.DefaultTask
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.io.File

@CacheableTask
open class ListAllThingsTask : DefaultTask() {

    @Input
    lateinit var list: Iterable<Any>

    @OutputFile
    val listFile = File(project.buildDir, "listOfThings.txt")

    @TaskAction
    fun listThings() {
        list.forEach {
            println(it)
        }
        listFile.writeText(list.joinToString())
    }
}