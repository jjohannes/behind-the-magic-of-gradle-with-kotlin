import org.gradle.api.DefaultTask
import org.gradle.api.file.FileCollection
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.io.File

open class CountAllThingsTask : DefaultTask() {

    @InputFiles
    lateinit var listFile: FileCollection

    @OutputFile
    val countFile = File(project.buildDir, "count.txt")

    @TaskAction
    fun countThings() {
        countFile.writeText(listFile.singleFile.readText().split(",").size.toString())
    }
}