apply {
    plugin("base")
}

val listTask = task<ListAllThingsTask>("listThings") {
    list = (1..20).toList()
}

task<CountAllThingsTask>("countThings") {
    dependsOn(listTask)
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

    @InputFile
    val listFile = File(project.buildDir, "listOfThings.txt")

    @OutputFile
    val countFile = File(project.buildDir, "count.txt")

    @TaskAction
    fun countThings() {
        countFile.writeText(listFile.readText().split(",").size.toString())
    }
}