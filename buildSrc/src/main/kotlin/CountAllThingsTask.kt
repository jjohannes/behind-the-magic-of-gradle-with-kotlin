import org.gradle.api.DefaultTask
import org.gradle.api.file.FileCollection
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.io.File
import java.util.zip.ZipFile

@CacheableTask
open class CountAllThingsTask : DefaultTask() {

    @InputFiles
    lateinit var listFile: FileCollection

    @InputFiles
    var moreListFiles: FileCollection = project.files()

    @OutputFile
    val countFile = File(project.buildDir, "count.txt")

    @TaskAction
    fun countThings() {
        countFile.writeText((moreListFiles + listFile).map {
            println("Counting entries in: ${it.name}")
            if (it.extension in listOf("zip", "jar", "aar")) {
                ZipFile(it).size()
            } else {
                it.readText().split(",").size
            }
        }.sum().toString())
    }
}