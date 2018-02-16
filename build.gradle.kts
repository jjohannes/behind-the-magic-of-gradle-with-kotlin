apply {
    plugin("base")
}

val listTask = task<ListAllThingsTask>("listThings") {
    list = (1..20).toList()
}

task<CountAllThingsTask>("countThings") {
    listFile = listTask.outputs.files
}

open class ListAllThingsTask : DefaultTask() {

    @Input
    lateinit var list: Iterable<Any>

    @OutputFile
    val listFile = File(project.buildDir, "listOfThings.txt")

    @TaskAction
    fun listThings() {
        list.forEach {
            println(it)
            Thread.sleep(200)
        }
        listFile.writeText(list.joinToString())
    }
}

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